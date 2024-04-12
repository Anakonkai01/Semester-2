#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
    int sum  = 0 ;
    for (size_t i = 0; i < argc; i++)
    {
        sum+= atoi(argv[i]);
    }
    
    printf("the sum of all the elements = %d\n",sum);

    return 0;
}
