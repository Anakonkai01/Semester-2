#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

struct arr {
    int n;
    int a[10];
};

struct file {
    struct arr ar;
    char* filename;
};

static int sum = 0;

void* thr1(void* arg) {
    struct arr *ap = (struct arr*) arg;
    ap->n = 3;
    for (int i = 0; i < ap->n; i++) {
        ap->a[i] = i + 1;
    }
    pthread_exit(NULL);
}

void* thr2(void* ar) {
    struct arr *ap = (struct arr*) ar;
    int s = 0;
    for (int i = 0; i < ap->n; i++) {
        s += ap->a[i];
    }
    sum = s;
    pthread_exit(NULL);
}

void* thr3(void* ar) {
    struct file *fi = (struct file*) ar;
    FILE *out;
    out = fopen(fi->filename, "w");
    if (out == NULL) {
        perror("Error opening file");
        pthread_exit(NULL);
    }
    fprintf(out, "number element of array: %d\n", fi->ar.n);
    for (int count = 0; count < fi->ar.n; count++) {
        fprintf(out, "%d\t", fi->ar.a[count]);
    }
    fprintf(out,"\n");
    fprintf(out, "sum=%d\n", sum);
    fclose(out);
    pthread_exit(NULL);
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <output_filename>\n", argv[0]);
        return 1;
    }

    pthread_t tid[3];
    struct arr ar;
    struct file arf;
    arf.ar = ar;
    arf.filename = argv[1];

    pthread_create(&tid[0], NULL, thr1, (void*) &ar);
    usleep(100000); // Sleep for 100 milliseconds
    pthread_join(tid[0], NULL);

    pthread_create(&tid[1], NULL, thr2, (void*) &ar);
    pthread_join(tid[1], NULL);

    pthread_create(&tid[2], NULL, thr3, (void*) &arf);
    pthread_join(tid[2], NULL);

    printf("Results have been written to %s\n", argv[1]);

    return 0;
}
