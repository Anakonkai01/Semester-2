#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

bool is_prime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6)
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    return true;
}

void generate_primes(int n, int limit, int *arr) {
    int count = 0;
    while (count < n) {
        int prime_candidate = rand() % limit + 1;
        if (is_prime(prime_candidate)) {
            arr[count++] = prime_candidate;
        }
    }
}

void write_to_file(const char *filename, int n, int *arr) {
    FILE *fp = fopen(filename, "w");
    if (fp != NULL) {
        fprintf(fp, "%d\n", n);
        int smallest = arr[0], largest = arr[0];
        for (int i = 0; i < n; i++) {
            fprintf(fp, "%d ", arr[i]);
            if (arr[i] < smallest) smallest = arr[i];
            if (arr[i] > largest) largest = arr[i];
        }
        fprintf(fp, "\n%d\n%d\n", smallest, largest);
        fclose(fp);
        printf("Output has been written to %s\n", filename);
    } else {
        printf("Error writing to file %s\n", filename);
    }
}

int main() {
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    
    int *array = (int *)malloc(n * sizeof(int));
    if (array == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }
    
    srand(time(NULL));
    generate_primes(n, 1000, array);
    
    write_to_file("output.txt", n, array);
    
    free(array);
    return 0;
}
