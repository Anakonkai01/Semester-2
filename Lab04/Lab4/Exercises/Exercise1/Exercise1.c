#include <stdio.h>
#include <stdlib.h>

#define BUFFER_SIZE 1024

int main(int argc, char *argv[]) {
    FILE *source_file = fopen(argv[1], "rb");
    if (source_file == NULL) {
        perror("Error opening source file");
        return 1;
    }

    FILE *target_file = fopen(argv[2], "wb");
    if (target_file == NULL) {
        perror("Error opening target file");
        fclose(source_file);
        return 1;
    }

    char buffer[BUFFER_SIZE];
    size_t bytes_read;
    while ((bytes_read = fread(buffer, 1, BUFFER_SIZE, source_file)) > 0) {
        size_t bytes_written = fwrite(buffer, 1, bytes_read, target_file);
        if (bytes_written != bytes_read) {
            perror("Error writing to target file");
            fclose(source_file);
            fclose(target_file);
            return 1;
        }
    }

    fclose(source_file);
    fclose(target_file);

    printf("File copied successfully.\n");
    return 0;
}
