#include <stdio.h>

int main(int argc, char *argv[]) {   
     // A completar 
    int i;
    for(i = 1; i< argc; i++){
        printf("Argumento %i es ", i);
        if(argv[i][0] == '-'){
        switch(argv[i][1]){
            case 'c':
                printf("Compilar\n");
                break;
            case 'E':
                printf("Procesar\n");
                break;
            case 'i':
                printf("Incluir %s\n", argv[i][2]);
                break;
            default: 
                printf("No valido");
            
        }
        }
    }
    return 0;
}
