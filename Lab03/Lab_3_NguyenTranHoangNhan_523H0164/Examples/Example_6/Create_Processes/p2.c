#include <stdio.h>
#include <unistd.h>

int main(){
	pid_t pid;
	if((pid = fork()) == 0){
		printf("child process: child ID = %d\n", getpid());
		printf("My parent ID: Parent ID = %d\n",getppid());
	}
	else if(pid > 0){
		printf("parent process: parent ID = %d\n",getpid());
		printf("child id = %d\n",pid);
	}
	else{
		printf("fork error!\n");
	}
	return 0;
}
