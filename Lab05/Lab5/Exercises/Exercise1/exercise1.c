#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

long long factorial_result = 1;
int count_smaller_numbers = 0;

typedef struct {
    char *arg1; 
    char *arg2; 
} ThreadArgs;

void *calculate_factorial(void *arg) {
    int num = atoi(((ThreadArgs *)arg)->arg1);

    for (int i = 2; i <= num; ++i) {
        factorial_result *= i;
    }

    pthread_exit(NULL);
}

void *count_smaller(void *arg) {
    long long factorial = factorial_result;
    
    for (long long i = 1; i < factorial; ++i) {
        count_smaller_numbers += i;
    }

    pthread_exit(NULL);
}

void *write_results(void *arg) {
    FILE *file = fopen(((ThreadArgs *)arg)->arg2, "w");

    fprintf(file, "N = %s\n", ((ThreadArgs *)arg)->arg1);
    fprintf(file, "%s! = %lld\n",((ThreadArgs *)arg)->arg1 ,factorial_result);
    fprintf(file, "Sum = %d\n", count_smaller_numbers);

    fclose(file);
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    pthread_t thread1, thread2, thread3;
    ThreadArgs args = {argv[1], argv[2]};

    pthread_create(&thread1, NULL, calculate_factorial, (void *)&args);
    pthread_join(thread1, NULL);

    pthread_create(&thread2, NULL, count_smaller, NULL);
    pthread_join(thread2, NULL);

    pthread_create(&thread3, NULL, write_results, (void *)&args);
    pthread_join(thread3, NULL);

    printf("Results have been written to %s\n", argv[2]);

    return 0;
}
