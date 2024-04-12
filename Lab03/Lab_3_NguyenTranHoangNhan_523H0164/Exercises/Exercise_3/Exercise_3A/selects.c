#include <stdio.h>

int main(int argc, char *argv[]) {
    int operation =  atoi(argv[1]);
    int n = atoi(argv[2]);
    if (operation == 1)
    {
        int result = sumToN(n);
        printf("Sum of numbers from 1 to %d: %d\n",n,result);
    }
    else if(operation == 2){
        int result = factorial(n);
        printf("Factorial of numbers from 1 to %d: %d\n", n, result);
    }
    else {
        printf("Invalid operation\n");
        return 1;
    }
    
    return 0;
}
