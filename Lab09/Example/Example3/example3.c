#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>
#include <sys/errno.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>

union semun{
    int val;
    struct semid_ds *buf;
    unsigned short int *array;
    struct seminfo *_buf;
} sarg;

int Init()
{
    int semid;
    if((semid=semget(IPC_PRIVATE,1,0666|IPC_CREAT))==-1) return -1;
    sarg.val=1;
    if(semctl(semid,0,SETVAL,sarg)==-1) return -1;
    return semid;
}

void P(int semid)
{
    struct sembuf buf;
    buf.sem_num = 0;
    buf.sem_op = -1; // decrease semaphore value
    buf.sem_flg = SEM_UNDO;
    if(semop(semid,&buf, 1)==-1){
        perror("semop\n"); exit(1);
   }
}

void V(int semid)
{
    struct sembuf buf;
    buf.sem_num = 0;
    buf.sem_op = 1; // increase semaphore value
    buf.sem_flg = SEM_UNDO;
    if(semop(semid, &buf, 1)==-1){
        perror("semop\n"); exit(1);
    }
}

int Clear(int semid)
{
    return semctl(semid,0,IPC_RMID,0);
}

void test3(int semid, int num){
    int i=0;
    while(i<num)
    {
        P(semid);  // enter section
        printf("%d do something in CS\n", getpid());
        sleep(4);
        V(semid);  //exit section
        printf("%d out of CS\n", getpid());
        sleep(1);
        i++;
    }
}

int main(int argc, char* argv[])
{
    if(argc != 2) {
        printf("Usage: %s <number_of_iterations>\n", argv[0]);
        exit(1);
    }

    int num = atoi(argv[1]);
    int semid=Init();
    if(semid == -1) {
        perror("Failed to initialize semaphore");
        exit(1);
    }
    if(fork()==0) test3(semid, num);
    else test3(semid, num);
    sleep(4);
    Clear(semid);
    return 0;
}
