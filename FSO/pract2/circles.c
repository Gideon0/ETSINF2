#include <stdio.h>

#define PI 3.1416
int main() {   
   float area, radio;
   radio = 10;   
   area = PI * (radio * radio);   
   printf("Area del circulo de radio %f es %f\n", radio, area); 
}
