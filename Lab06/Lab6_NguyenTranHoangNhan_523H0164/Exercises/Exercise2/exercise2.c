#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

#define FIFO_PATH "/tmp/myfifo"

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

    int n = atoi(argv[1]);
    int num1, num2;
    char op;

    int fd;
    int pipe_fd[2];

    mkfifo(FIFO_PATH, 0666); 

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
        calculate_factorial(n, pipe_fd[1]);
        close(pipe_fd[1]); 
        exit(EXIT_SUCCESS);
    } else { 
        close(pipe_fd[1]); 
        read(pipe_fd[0], &num1, sizeof(num1));
        close(pipe_fd[0]); 
        printf("Factorial of %d: %d\n", n, num1);

        printf("Enter two integers and an operation (+, -, *, /): ");
        scanf("%d %d %c", &num1, &num2, &op);

        mkfifo(FIFO_PATH, 0666); 

        if (pipe(pipe_fd) == -1) {
            perror("pipe");
            exit(EXIT_FAILURE);
        }

        pid = fork();

        if (pid == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }

        if (pid == 0) { 
            close(pipe_fd[1]); 
            read(pipe_fd[0], &num1, sizeof(num1));
            read(pipe_fd[0], &num2, sizeof(num2));
            read(pipe_fd[0], &op, sizeof(op));

            int result = perform_operation(num1, num2, op);

            close(pipe_fd[0]); 

            fd = open("result.txt", O_WRONLY | O_CREAT, 0666);
            if (fd == -1) {
                perror("open");
                exit(EXIT_FAILURE);
            }
            printf("\nResult written to file 'result.txt'.");
            dprintf(fd, "%d %c %d = %d\n", num1, op, num2, result);
            close(fd);

            exit(EXIT_SUCCESS);
        } else { 
            close(pipe_fd[0]); 
            write(pipe_fd[1], &num1, sizeof(num1));
            write(pipe_fd[1], &num2, sizeof(num2));
            write(pipe_fd[1], &op, sizeof(op));
            close(pipe_fd[1]); 
        }
    }

    return 0;
}
