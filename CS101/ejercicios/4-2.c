#include <stdio.h>
int a, b , c,m2, total, fabrica, tapas;
int main( ) {
  printf("\n\n\n\n\n\n\n");
  printf("Indica la cantidad de tinacos del modeo A :  ");
  scanf("%d",&a);
  printf("Indica la cantidad de tinacos del modeo B :  ");
  scanf("%d",&b);
  printf("Indica la cantidad de tinacos del modeo C :  ");
  scanf("%d",&c);
  m2 = a * 10 + b * 15 + c* 20;
  tapas = a + b + c;
  printf("******************************");
  printf("\nCantidad de :");
  printf("\n     M2 de plastico     : %8d", m2);
  printf("\n     Tapas de 1.0 metro : %8d", a);
  printf("\n     Tapas de 1.5 metros: %8d", b);
  printf("\n     Tapas de 2.0 metros: %8d", c);
  printf("\n     Flotadores:        : %8d",a+b+c);
  printf("\n******************************");
  printf("\nCosto total : %8d", (a*10*50)+(b*15*50)+(c*20*50)+(a+b+c)*20 + a*25+b*35+c*45);
  printf("\nPrecio final: %8d", a*760 +b*1130+c*1490);
  printf("\n\n\n\n\n\n");
  print(float(a));
  return 0;
}
