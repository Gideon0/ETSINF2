#include <stdio.h>

int main(int argc, char *argv[]) {   
     // A completar 
    printf("Numero de argumentos = %i\n", argc);
        int i;
        for(i = 0; i < argc; i++){
            printf("\tArgumento %i es = %s\n", i, argv[i]);
        }
        
}
