#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char **argv){
    int pnum, count, retval, child_no;
    pnum = atoi(argv[1]);
    if(pnum <= 0){
        printf("Tien Trinh = 0");
        return -1;
    }
    else{
        retval = 1;
        // tao tien trinh
        for (count = 0; count < pnum; count++)
        {
            if(retval != 0) retval = fork();
            else break;
        }
        // thuc thi tien trinh con
        if(retval == 0){
            child_no = count;
            printf("Tien trinh so: %d, PID: %d\n", child_no, getpid());
        }
        else{
            // cho tien trinh con ket thuc
            for (count = 0; count< pnum;count++)
            {
                wait(NULL);
            }
            printf("Id Tien trinh cha: %d\n",getpid());
        }
        return 0;
    }
}