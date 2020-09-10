#include <stdio.h>

float x,y,alambre,precio, total;
int polines;

int main(){
  printf("\n\n\n\n\n");
  printf("Metros de frente : ");
  scanf("%f",&x);
  printf("Metros de fondo : ");
  scanf("%f",&y);
  printf("\n\n\n");
  printf("*****************************************");
  polines = (x + y) * 2 / 3;
  printf("\nCantidad de polines requerida    : %8.2f", (float) polines);\
  total = (x + y) * 2;
  printf("\nCantidad de metros de alambre    : %8.2f", total * 3);
  printf("\nEl costo total de los polines es : %8.2f", (float) polines * 55);
  precio = (polines * 55 ) + (total *3) * 3;
  printf("\nEl costo total del alambre es    : %8.2f",(total * 3) *3 ) ;
  printf("\n*****************************************\n");
  printf("costo total : %8.2f", precio);


  printf("\n\n\n\n\n\n ");
  return 0;
}
