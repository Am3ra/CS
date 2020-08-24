#include <stdio.h>


int main() {
  float x = 13.36;
  printf("Dolares    Pesos\n");
  printf("****************\n");
  for (  int i = 10; i < 100;) {
    float pesos = x * i;
    printf("%d             %f\n",i,pesos );
    i += 10;
  }
  return 0;
}
