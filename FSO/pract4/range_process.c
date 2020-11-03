#include <stdio.h>
#include <stdlib.h>
int main (int argc, char *argv[]) {
    int i;
    for (i = 1; i < 6; i++) {
        if (fork()  == 0) {
            printf("Hijo creado en iteración= %d\n", i);
            exit(i);
        }
    }
    sleep(10);
    exit (0);
}
