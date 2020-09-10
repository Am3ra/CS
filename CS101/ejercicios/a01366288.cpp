#include <stdio.h>
int a,n=0,m=1,l,sum;
int main() {
  while ((a < 1 || a > 100)) {
    a=0;
    printf("Ingrese digito entre 1 y 100, incluyendo los limites:  ");
    scanf("%d", &a);
    if ((a < 1 || a > 100) && a % 2 == 0){
      printf("Valor incorrecto\n\n");
    }
  }
  printf("------------------------\n");
  printf("0\n");
  while (l<= a){
    sum+=m;
    printf("%d\n",m);
    l=m+n;
    n=m;
    m=l;
  }
  printf("------------------------\n");
  printf("Suma final: %d\n",sum );
  return 0;
}
