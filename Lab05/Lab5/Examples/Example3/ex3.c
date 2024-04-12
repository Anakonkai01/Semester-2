#include <stdio.h>
#include <pthread.h>

void* thr1(void* arg) {
  int count;  

  printf("this is thread %d\n", *((int*)arg));
  sleep(2);

  return NULL;
}

int main(int argc, char* argv[]) {
  int i;
  pthread_t tid[3]; 
  int status; 

  for (i = 0; i < 3; i++) {
    pthread_create(&tid[i], NULL, thr1, (void*)&tid[i]);  
  }

  for (i = 0; i < 3; i++) {
    if (pthread_join(tid[i], (void**) &status) > 0) {  
      printf("pthread_join for thread %d failure\n", (int)tid[i]);
      return 0; 
    }
    printf("pthread_waited for %d OK, return code: %d\n", (int)tid[i], status);
    sleep(1);  
  }

  sleep(1);  
  return 0; 
}
