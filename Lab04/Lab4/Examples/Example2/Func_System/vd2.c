#include <stdio.h>

int main(int argc, char const *argv[])
{
    int re;
    printf("Call system to execute ls -a\n");
    re=system("ls -a");
    if(re!= 1) printf("Call ls -a OK!\n");
    printf("Call system to execute ps -a\n");
    re=system("ps -a");
    if(re!= 1) printf("Call ps -a OK!\n");
    return 0;
}
