#include <stdio.h>

int x, y;
float r;

int main() {
  printf("Indica el valor entero   :");
  scanf("%d",&x );
  printf("indica valor flotante   :");
  scanf("%d",&y);

  r = (float) x /(float) y;

  printf("este es el resultado:  %f", r);

  return 0;
}
