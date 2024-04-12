#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int *array;
int array_size;

typedef struct {
    char *filename; 
    char *output_filename; 
} ThreadArgs;

int is_prime(int num) {
    if (num <= 1) return 0;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return 0;
    }
    return 1;
}

void *calculate_sum_of_primes(void *arg) {
    int sum = 0;
    for (int i = 0; i < array_size; i++) {
        if (is_prime(array[i])) {
            sum += array[i];
        }
    }
    int *result = (int *)malloc(sizeof(int));
    if (result == NULL) {
        perror("Error allocating memory");
        exit(EXIT_FAILURE);
    }
    *result = sum;
    pthread_exit((void *)result);
}

void *sort_array(void *arg) {
    for (int i = 0; i < array_size - 1; i++) {
        for (int j = 0; j < array_size - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    pthread_exit(NULL);
}

void *write_results(void *arg) {
    FILE *file = fopen(((ThreadArgs *)arg)->output_filename, "w");
    if (file == NULL) {
        perror("Error opening file");
        pthread_exit(NULL);
    }

    fprintf(file, "Size of array: %d\n", array_size);
    fprintf(file, "Value of elements: ");
    for (int i = 0; i < array_size; i++) {
        fprintf(file, "%d ", array[i]);
    }
    fprintf(file, "\n");

    void *sum_result;
    pthread_t sum_thread;
    pthread_create(&sum_thread, NULL, calculate_sum_of_primes, NULL);
    pthread_join(sum_thread, &sum_result);
    int sum = *((int *)sum_result);
    free(sum_result); 

    fprintf(file, "Primes: ");
    for (int i = 0; i < array_size; i++) {
        if (is_prime(array[i])) {
            fprintf(file, "%d ", array[i]);
        }
    }
    fprintf(file, "\nSum of Primes: %d\n", sum);

    fprintf(file, "Primes sorted from smallest to highest: ");
    for (int i = 0; i < array_size; i++) {
        if (is_prime(array[i])) {
            fprintf(file, "%d ", array[i]);
        }
    }
    fprintf(file, "\n");

    fclose(file);
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }

    FILE *input_file = fopen(argv[1], "r");
    if (input_file == NULL) {
        perror("Error opening file");
        return 1;
    }
    

    fscanf(input_file, "%d", &array_size);
    array = (int *)malloc(array_size * sizeof(int));
    if (array == NULL) {
        perror("Error allocating memory");
        return 1;
    }
    printf("Array size: %d\n", array_size);
    
    for (int i = 0; i < array_size; i++) {
        fscanf(input_file, "%d", &array[i]);
        printf("Read element %d: %d\n", i, array[i]);
    }
    fclose(input_file);

    ThreadArgs args = {argv[1], "output.txt"};

    pthread_t thread1, thread2, thread3;

    pthread_create(&thread1, NULL, sort_array, NULL);
    pthread_create(&thread2, NULL, calculate_sum_of_primes, NULL);
    pthread_create(&thread3, NULL, write_results, (void *)&args);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    pthread_join(thread3, NULL);

    free(array);

    printf("Results have been written to output.txt\n");

    return 0;
}

