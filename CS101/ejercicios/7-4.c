#include <stdio.h>

int a;

int main() {
  printf("Ingrese digito entre 1 y 100, incluyendo los limites:  ");
  scanf("%d", &a);
  if ((a < 1 || a > 1000) && a % 2 == 0){
    printf("Valor incorrecto");
  } else printf("Ingrese segundo valor");
  scanf("%d",&a);
  if ((a < 1 || a > 1000) && a % 2 == 0){
    printf("Valor incorrecto");
  } else printf("VALORES CORRECTOS");
  return 0;
}
