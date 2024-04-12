#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>

#define BUFFER_SIZE 256  

struct Message {
    long mtype;
    char content[BUFFER_SIZE];
};

int main(int argc, char* argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    key_t key;
    int mid;
    struct Message msg;

    if ((key = ftok(".", 'a')) == -1) {
        perror("ftok");
        return 1;
    }

    if ((mid = msgget(key, IPC_CREAT | 0666)) == -1) {
        perror("msgget");
        return 1;
    }

    switch (fork()) {
        case -1:
            perror("fork");
            return 1;
        case 0:  
            msg.mtype = 10;

            FILE* file = fopen(argv[1], "r");
            if (file == NULL) {
                perror("fopen (child)");
                return 1;
            }

            int num1, num2;
            char op;
            if (fscanf(file, "%d %c %d", &num1, &op, &num2) != 3) {
                perror("fscanf");
                exit(1);
            }
            fclose(file);

            snprintf(msg.content, BUFFER_SIZE, "%d %c %d", num1, op, num2);  

            if (msgsnd(mid, &msg, strlen(msg.content) + 1, 0) == -1) {
                perror("msgsnd (child)");
                return 1;
            }

            printf("Child process sent: %s\n", msg.content);

            if (msgrcv(mid, &msg, BUFFER_SIZE, 11, 0) == -1) {
                perror("msgrcv (child)");
                return 1;
            }

            msg.content[strlen(msg.content)] = '\0';  
            printf("Child process received: %s\n", msg.content);

            file = fopen(argv[1], "w");
            if (file == NULL) {
                perror("fopen (child)");
                return 1;
            }
            fprintf(file, "%s\n", msg.content);
            fclose(file);

            return 0;
        default:  
            sleep(1); 

            printf("Parent process receiving from child:\n");
            if (msgrcv(mid, &msg, BUFFER_SIZE, 10, 0) == -1) {
                perror("msgrcv (parent)");
                return 1;
            }

            msg.content[strlen(msg.content)] = '\0';  
            printf("%s\n", msg.content);

            int num1, num2, result;
            char op;
            sscanf(msg.content, "%d %c %d", &num1, &op, &num2);

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        printf("Error: Division by zero\n");
                        return 1;
                    }
                    result = num1 / num2;
                    break;
                default:
                    printf("Error: Invalid operation\n");
                    return 1;
            }

            snprintf(msg.content, BUFFER_SIZE, "%d", result);
            msg.mtype = 11;  

            if (msgsnd(mid, &msg, strlen(msg.content) + 1, 0) == -1) {
                perror("msgsnd (parent)");
                return 1;
            }

            // Wait for the child to finish
            wait(NULL);

            // Remove the message queue
            if (msgctl(mid, IPC_RMID, NULL) == -1) {
                perror("msgctl");
                return 1;
            }

            return 0;
    }
}
