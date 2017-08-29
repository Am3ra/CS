#include <stdio.h>

float a,b;

int main() {
  printf("Ingrese digito entre 1 y 100, incluyendo los limites:  ");
  scanf("%f", &a);
  if (a < 1 || a > 100){
    printf("Valor incorrecto");
  } else printf("Ingrese segundo valor");
  scanf("%f",&a);
  if (a < 1 || a > 100){
    printf("Valor incorrecto");
  } else printf("VALORES CORRECTOS");
  return 0;
}
