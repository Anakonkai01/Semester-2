#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isPrime(int n) {
    if (n <= 1)
        return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

void swap(int* a, int* b)
{
   int temp;
   temp = *a;
   *a = *b;
   *b = temp;
}

void BubbleSort(int arr[], int N)
{
   int i, j;
   for (i = 0; i < N; i++)
   {
       for (j = N-1; j > i; j--)
       {
           if(arr[j] < arr[j-1])
               swap(&arr[j], &arr[j-1]);
       }
   }
}



int main() {
    FILE *inputFile, *outputFile;
    int n, num, sum = 0, count = 0;
    int primeNumbers[100000]; 

    
    inputFile = fopen("input.txt", "r");
    outputFile = fopen("output.txt", "w");
    if (inputFile == NULL) {
        perror("Error opening input file");
        return EXIT_FAILURE;
    }
    if (outputFile == NULL) {
        perror("Error opening output file");
        return EXIT_FAILURE;
    }

    // Read number of elements
    fscanf(inputFile, "%d", &n);    
    

    // Read each element, find primes, and calculate sum
    for (int i = 0; i < n; i++) {
        fscanf(inputFile, "%d", &num);
        if (isPrime(num)) {
            sum += num;
            primeNumbers[count++] = num;
        }
    }

    // Sort prime numbers in increasing order

    // Print the count of prime numbers
    fprintf(outputFile, "%d\n", count);

    // Print the sum of primes
    fprintf(outputFile, "Sum = %d\n", sum);

    // Print the prime numbers
    for (int i = 0; i < count; i++) {
        fprintf(outputFile, "%d ", primeNumbers[i]);
    }
    fprintf(outputFile, "\n");

    // sort
    BubbleSort(primeNumbers, count);
    for (int i = 0; i < count; i++) {
        fprintf(outputFile, "%d ", primeNumbers[i]);
    }

    // Close files
    fclose(inputFile);
    fclose(outputFile);

    return 0;
}
