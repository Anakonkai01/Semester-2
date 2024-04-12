#include <stdio.h>

int main(){
    int n = 10;
    printf("With n = 10\n");
    int sum = 0;

	for (size_t i = 1; i <= n; i++)
    {
        sum+= i;    
    }

    printf("The sum of first n positive integers = %d\n",sum);
    
}
