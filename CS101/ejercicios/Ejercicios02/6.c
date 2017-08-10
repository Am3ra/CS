#include <stdio.h>


int main() {
  float x = 13.36;
  printf("Dolares    Pesos");
  printf("****************");
  for (  int i = 10; i < 100;) {
    float pesos = x * i;
    printf("%d             %f",i,pesos );
    i += 10;
  }
  return 0;
}
