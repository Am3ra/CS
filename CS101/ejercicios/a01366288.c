#include <stdio.h>

float v1, v2, v3, desc, total, totalc;
char mejor[12];

int main(int argc, char const *argv[]) {

  printf("Indique las ventas del vendedor 1: ");
  scanf("%f",&v1);
  printf("Indique las ventas del vendedor 2: ");
  scanf("%f",&v2);
  printf("Indique las ventas del vendedor 3: ");
  scanf("%f",&v3);

  printf("---------------------------------------\n");



  total = v1 + v2 + v3;

  if (v1 <= 10000){
    desc = 0;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v1);
    totalc = totalc + desc * v1;

  } else if (v1 > 10000 && v1 <= 50000){
    desc = 0.02;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v1);
    totalc = totalc + desc * v1;


  } else if (v1 > 50000 && v1 <= 100000){
    desc = 0.03;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v1);
    totalc = totalc + desc * v1;

  } else if (v1 > 100000){
    desc = 0.04;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v1);
    totalc = totalc + desc * v1;

  }

  if (v2 <= 10000){
    desc = 0;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v2);
    totalc = totalc + desc * v2;

  } else if (v2 > 10000 && v2 <= 50000){
    desc = 0.02;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v2);
    totalc = totalc + desc * v2;


  } else if (v2 > 50000 && v2 <= 100000){
    desc = 0.03;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v2);
    totalc = totalc + desc * v2;

  } else if (v2 > 100000){
    desc = 0.04;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v2);
    totalc = totalc + desc * v2;

  }

  if (v3 <= 10000){
    desc = 0;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v3);
    totalc = totalc + desc * v3;

  } else if (v3 > 10000 && v3 <= 50000){
    desc = 0.02;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v3);
    totalc = totalc + desc * v3;


  } else if (v3 > 50000 && v3 <= 100000){
    desc = 0.03;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v3);
    totalc = totalc + desc * v3;

  } else if (v3 > 100000){
    desc = 0.04;
    printf("Comisi%cn del vendedor 1 en porcentaje: %2.0f \n", 162, desc*100);
    printf("Comisi%cn del vendedor 1 en pesos     : %2.0f \n", 162, desc*v3);
    totalc = totalc + desc * v3;

  }

  mejor = "Vendedor 1";
  if (v2>v1){
    mejor = "Vendedor 2";
    if (v3>mejor){
      mejor = "Vendedor 3";
    }
  }
  if (v3>mejor){
    mejor = "vendedor 3";
  }

  printf("Total de ventas                       : %.0f \n",total);
  printf("Total de comiones                     : %.0f \n",totalc);


  return 0;
}
