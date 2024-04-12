#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int c, num, count = 0, i = 0;
    int ar[100];
    FILE *in, *out;
    in = fopen(argv[1], "r");
    fscanf(in,"%d", &num);
    while(i<num) {
        fscanf(in,"%d", &c);
        ar[i] = c;
        i++;
    }
    fclose(in);
    out = fopen(argv[2], "wb");
    for(count = 0; count < num; count++) {
        printf("%d\t", ar[count]);
    }
    printf("\n");
    fprintf(out,"%d\n", num);
    for(count = 0; count < num; count++) {
        fprintf(out,"%d\t", ar[count]);
    }
    return 0;
}
