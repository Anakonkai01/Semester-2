#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <string.h>
#include <fcntl.h>

#define SIZE 256

int main() {
    int *shm0, *shm1, shmid0, shmid1;
    key_t key0, key1;

    if ((key0 = ftok(".", 'a')) == -1 || (key1 = ftok(".", 'b')) == -1) {
        perror("Error creating keys\n");
        return 1;
    }

    if ((shmid0 = shmget(key0, SIZE, IPC_CREAT | 0666)) == -1 ||
        (shmid1 = shmget(key1, SIZE, IPC_CREAT | 0666)) == -1) {
        perror("Error creating shared memory segments\n");
        return 2;
    }

    shm0 = (int *)shmat(shmid0, 0, 0);
    shm1 = (int *)shmat(shmid1, 0, 0);

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        perror("Error opening file\n");
        return 3;
    }
    int num1, num2;
    char operation;
    fscanf(file, "%d %d %c", &num1, &num2, &operation);
    fclose(file);

    shm0[0] = num1;
    shm0[1] = num2;
    shm0[2] = operation;

    if (fork() == 0) {
        switch (shm0[2]) {
            case '+':
                shm1[0] = shm0[0] + shm0[1];
                break;
            case '-':
                shm1[0] = shm0[0] - shm0[1];
                break;
            case '*':
                shm1[0] = shm0[0] * shm0[1];
                break;
            case '/':
                shm1[0] = shm0[0] / shm0[1];
                break;
            default:
                perror("Invalid operation\n");
                return 4;
        }
        exit(0);
    } else {
        wait(NULL);

        file = fopen("output.txt", "w");
        if (!file) {
            perror("Error opening file for writing\n");
            return 5;
        }
        fprintf(file, "Result: %d\n", shm1[0]);
        fclose(file);
    }

    shmdt((void *)shm0);
    shmdt((void *)shm1);

    shmctl(shmid0, IPC_RMID, NULL);
    shmctl(shmid1, IPC_RMID, NULL);

    return 0;
}
