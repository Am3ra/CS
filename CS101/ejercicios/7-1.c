#include <stdio.h>


float b, llan, fren, marco, asiento, total, desc;

int main() {

  printf("Indica la cantidad de Bicicletas :");
  scanf("%f",&b);
  printf("Indica la cantidad de llantas    :");
  scanf("%f",&llan);
  printf("Indica la cantidad de frenos     :");
  scanf("%f",&fren);
  printf("Indica la cantidad de marcos     :");
  scanf("%f",&marco);
  printf("Indica la cantidad de asientos   :");
  scanf("%f",&asiento);
  printf("\n\n");
  printf("************************************************** \n");

  total = b*1200+llan*250+fren*150+marco*600+asiento*200;


  if (total < 1000){
    desc = 1.0;
  } else if (total >= 1000 && total < 3000){
    desc = 0.9;
  } else if (total >= 3000 && total < 6000){
    desc = 0.85;
  } else if (total >= 6000){
    desc = 0.80;
  }
  printf("La venta total es      :  %8.2f \n", total);
  printf("Descuento total es     :  %8.2f", (1-desc)*100); printf("\% \n");
  printf("Importe total es       :  %8.2f \n", total * desc);

  printf("\n\n\n\n\n");

  return 0;
}
