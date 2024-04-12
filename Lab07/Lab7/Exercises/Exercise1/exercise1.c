#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define MAX_SIZE 10 

struct message {
  long type; 
  int data;  
};

int main(int argc, char* argv[]) {
  if (argc != 2) {
    printf("Usage: %s <number>\n", argv[0]);
    return 1;
  }

  int n = atoi(argv[1]); 

  pid_t pid = fork(); 
  if (pid == -1) {
    perror("fork");
    exit(1);
  }


  key_t key = ftok(".", 'A'); 
  int msgid = msgget(key, IPC_CREAT | 0666); 
  if (msgid == -1) {
    perror("msgget");
    exit(1);
  }

  if (pid == 0) { 
    struct message msg_send;
    msg_send.type = 1; 
    msg_send.data = n;
    if (msgsnd(msgid, &msg_send, sizeof(msg_send.data), 0) == -1) {
      perror("msgsnd");
      exit(1);
    }

    struct message msg_recv;
    if (msgrcv(msgid, &msg_recv, sizeof(msg_recv.data), 2, 0) == -1) {
      perror("msgrcv");
      exit(1);
    }

    printf("Sum of factorial from 1 to %d: %d\n", n, msg_recv.data);
  } else { 
    struct message msg_recv;
    if (msgrcv(msgid, &msg_recv, sizeof(msg_recv.data), 1, 0) == -1) {
      perror("msgrcv");
      exit(1);
    }

    int sum = 0; 
    for (int i = 1; i <= msg_recv.data; i++) {
      int factorial = 1;
      for (int j = 2; j <= i; j++) {
        factorial *= j;
      }
      sum += factorial;
    }

    msg_recv.type = 2;
    msg_recv.data = sum;
    if (msgsnd(msgid, &msg_recv, sizeof(msg_recv.data), 0) == -1) {
      perror("msgsnd");
      exit(1);
    }
  }

  msgctl(msgid, IPC_RMID, NULL);

  return 0;
}
