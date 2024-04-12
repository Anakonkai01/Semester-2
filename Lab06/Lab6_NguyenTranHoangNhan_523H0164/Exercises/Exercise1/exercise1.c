#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void calculate_factorial(int n, int pipe_write_fd) {
    int factorial = 1;
    for (int i = 1; i <= n; ++i) {
        factorial *= i;
    }
    write(pipe_write_fd, &factorial, sizeof(factorial));
}

int perform_operation(int num1, int num2, char op) {
    switch(op) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
        case '/':
            return num1 / num2;
        default:
            return -1; 
    }
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <integer>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int pipe_fd[2];
    if (pipe(pipe_fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    pid_t pid = fork();

    if (pid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) { 
        close(pipe_fd[0]); 

        int n = atoi(argv[1]);
        calculate_factorial(n, pipe_fd[1]);

        close(pipe_fd[1]); 
        exit(EXIT_SUCCESS);
    } else { 
        close(pipe_fd[1]); 

        int num1, num2;
        char op;

        printf("Enter two integers and an operation (+, -, *, /): ");
        scanf("%d %d %c", &num1, &num2, &op);

        int result;
        read(pipe_fd[0], &result, sizeof(result));
        printf("Result received from child process: %d\n", result);

        close(pipe_fd[0]); 

        FILE *fp = fopen("result.txt", "w");
        if (fp == NULL) {
            perror("fopen");
            exit(EXIT_FAILURE);
        }

        fprintf(fp, "%d %c %d = %d\n", num1, op, num2, perform_operation(num1, num2, op));
        fclose(fp);

        printf("Result written to file 'result.txt'.\n");
    }

    return 0;
}
