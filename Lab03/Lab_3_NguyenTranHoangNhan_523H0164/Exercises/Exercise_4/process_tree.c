#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid_A, pid_B, pid_C, pid_D, pid_E, pid_H;

    pid_A = getpid();
    printf("A: PID=%d, Parent PID=%d\n", pid_A, getppid());

    pid_B = fork();
    if (pid_B == 0) {
        printf("B: PID=%d, Parent PID=%d\n", getpid(), getppid());
        pid_D = fork(); 
        if (pid_D == 0) {
            printf("D: PID=%d, Parent PID=%d\n", getpid(), getppid());
            exit(0);
        } else if (pid_D > 0) {
            pid_E = fork(); 
            if (pid_E == 0) {
                printf("E: PID=%d, Parent PID=%d\n", getpid(), getppid());
                exit(0);
            }
        }
    } else if (pid_B > 0) {
        pid_C = fork();
        if (pid_C == 0) {
            printf("C: PID=%d, Parent PID=%d\n", getpid(), getppid());
            pid_H = fork(); 
            if (pid_H == 0) {
                printf("H: PID=%d, Parent PID=%d\n", getpid(), getppid());
                exit(0);
            }
        }
    }

    // Wait for all child processes to finish
    while (wait(NULL) > 0);
    return 0;
}
