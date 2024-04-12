#include <stdio.h>
#include <unistd.h>

int main(){
	printf("current process ID: %d\n",getpid());
	printf("Parent process ID: %d\n",getppid());
	return 0;
}
