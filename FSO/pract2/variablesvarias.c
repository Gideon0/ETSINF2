#include <stdio.h>
int a = 0; /* variable global */
// Función incrementa en 1 el valor de la variable global a
void inc_a(void) {
 //int a;
 a++;
}
// Función retorna el valor anterior de v y guarda el nuevo valor v
int valor_anterior(int v) {
 int temp;

// Declare aquí la variable s como estática
 static int s;
 temp = s;
 s = v;
 return temp;
}
main()
{
int b = 2; /* variable local */
inc_a();
valor_anterior(b);
printf("a= %d, b= %d\n", a, b);
a++;
b++;
inc_a();
 b = valor_anterior(b);
printf("a= %d, b= %d\n", a, b);
}
