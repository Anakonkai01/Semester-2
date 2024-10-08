#include <stdio.h>
#include <unistd.h>
#include <limits.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <string.h>
#include <stdlib.h>
#define SIZE 256
int main(int argc, char* argv[])
{
    int *shm, shmid, k;
    key_t key;
    if((key=ftok(".", 'a'))==-1){
        perror("key created\n");
        return 1;
    }
    if((shmid = shmget(key, SIZE, IPC_CREAT | 0666)) == -1){
        perror("SM created\n");
        return 2;
    }
    shm = (int*) shmat(shmid,0,0);
    switch(fork()){
        case -1: perror("fork error\n");
                return 4;
        case 0:
            shm[0] = atoi(argv[1]);
            shm[1] = atoi(argv[2]);
            sleep(3);
            printf("%d + %d = %d\n", shm[0], shm[1], shm[2]);
            shmdt((void*) shm);
            shmctl(shmid, IPC_RMID, (struct shmid_ds*)0);
            return 0;
        default:
            sleep(1);
            shm[2] = shm[1] + shm[0];
            shmdt((void*)shm);
            sleep(5);
            return 0;
    }
}
