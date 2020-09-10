#include <stdio.h>
int main() {
  float  total=0, max, min, odd,promedio, even;
  int a,c,i;
  printf("\n\n\n");
  printf("Digite el numero de elementos:\n");
  scanf("%d", &a);
  printf("Digite %d elementos:\n",a);
  int numb[a];
  for (c = 0; c < a; c++) {
    scanf("%d", &numb[c]);
    total += numb[c];
    if (c == 0){
      max = numb[0];
      min = numb[0];
    }
    if (numb[c] > max){
      max = numb[c];
    }
    if (numb[c] < min){
      min = numb[c];
    }
  }
  promedio = (float) total / (float) a;
  printf("El promedio es : %4.2f \n", promedio);
  printf("El mayor es    : %4.0f \n", max);
  printf("El menor es    : %4.0f \n", min);
  printf("Los numeros pares son: \n");
  for (i = 0; i < a; i++) {
    if (numb[i] % 2 == 0){
      printf("%d ,", numb[i]);
      printf("\n");
    }
  }
  printf("Los numeros nones son:");
  for (i = 0; i < a; i++) {
    if (numb[i] % 2 != 0){
      printf("%d ,", numb[i]);
      printf("\n");
    }
  }
  printf("\n\n\n");
  return 0;
}
