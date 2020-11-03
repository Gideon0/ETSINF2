#include <stdio.h>
//#define N 10

int Number;

int main()
{
    
    printf("Escriba el numero a ser impreso:");
    scanf("%d", &Number);
    
    int i;
    
    //Number = N;
    
    printf(" The first %d natural numbers are:\n", Number);
    for (i = 0; i<Number; i++)
    { printf("   %d \n", i);
    }
    
    printf("BYE\n");
    return(0);
}
    
