#include <stdio.h>
#include <unistd.h>
int main()

{
    int pid, pid1;
    if ((pid = fork()) == 0) {

        printf("--B--\n");
        printf("This is B: ID = %d\n", getpid());
        printf("Parent: A ID = %d\n", getppid());
        printf("\n");

    } else if (pid > 0) {
        printf("end B--\n");
        if ((pid1 = fork()) == 0) {

            printf(".-C...\n");
            printf("This is C: ID = %d\n", getpid());
            printf("Parent: A ID = %d\n", getppid());
            printf("\n");

        } else if (pid1 > 0) {
            printf("end\n");
            printf("----Parent A: ID=%d\n", getppid());

        } else {
            printf("fork error!\n");
        }
    } else {
        printf("fork error!\n");
    }
    return 0;
}
