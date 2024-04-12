#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

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

    if (fork() == 0) {
        int numElements = 5; // Example: Number of array elements
        shm0[0] = numElements;
        for (int i = 1; i <= numElements; ++i) {
            shm0[i] = i * 2; 
        }
        exit(0);
    }

    wait(NULL); 
    int sum = 0;
    for (int i = 1; i <= shm0[0]; ++i) {
        sum += shm0[i];
    }

    shm1[0] = sum;

    printf("Sum of array elements: %d\n", shm1[0]);

    shmdt((void *)shm0);
    shmdt((void *)shm1);

    shmctl(shmid0, IPC_RMID, NULL);
    shmctl(shmid1, IPC_RMID, NULL);

    return 0;
}
