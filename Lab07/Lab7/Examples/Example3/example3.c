#include <stdio.h>
#include <unistd.h>
#include <limits.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#define MAX 5

int main(int argc, char* argv[]){
    int mid;
    key_t key;
    struct msqid_ds buf;
    key = ftok(".",'a');
    if((mid = msgget(key,IPC_CREAT | 0666)) == -1){
        perror("Queue create\n");
        return 1;
    }
    msgctl(mid,IPC_STAT,&buf);
    printf("MQ Permission structure information\n");
    printf("Owner's user ID: %d\n",buf.msg_perm.uid);
    printf("Owner's group ID: %d\n",buf.msg_perm.gid);
    printf("Creator's user ID: %d\n",buf.msg_perm.cuid);
    printf("Creator's group ID: %d\n",buf.msg_perm.cgid);
    printf("Access mode in hex: %04x\n",buf.msg_perm.mode);
    printf("----------------------------------------------\n");
    printf("Additional selected MQ structure information\n");
    printf("Current number of byte in queue: %d\n",buf.__msg_cbytes);
    printf("Current number of messages on queue: %d\n",buf.msg_qnum);
    printf("Maximum number of bytes on queue: %d\n",buf.msg_qbytes);
    msgctl(mid,IPC_RMID,(struct msqid_ds*)0);
    return 0;
}