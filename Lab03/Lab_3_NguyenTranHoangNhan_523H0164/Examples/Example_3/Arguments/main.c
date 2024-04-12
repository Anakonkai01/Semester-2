#include <stdio.h>

int main (int argc, char **argv){
	printf("so doi so truyen vao: %i\n",argc);
	printf("gia tri cac doi so: ");
	int i = 0;
	for(int i = 0; i < argc; i++){
		printf("%s\t",argv[i]);
	}
	printf("\n");
	return 0;

}
