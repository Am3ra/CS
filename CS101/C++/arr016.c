
 #include <ncurses.h>
 #define clear() printf("\033[H\033[J")
 #define gotoxy(x,y) printf("\033[%d;%dH", (x), (y))



#include <stdio.h>
#include <stdlib.h>

float a[100];
int n, aux[100];

void captura(){
  clear();
  for (int i=0;i<99;i++){
    printf("Valor %d:",i);
    scanf("%f",&a[i]);
    if (a[i]==0){
      n=i;
      break;
    }
  }
}

void muestra(){
  clear();
  printf("Los Valores Capturados son:\n");
  for (int i = 0; i <n;i++){
    printf("%f",a[i]);
  }
}

float promedio(){
  clear();
  float s = 0,prom;
  for (int i = 0; i < n ; i++){
    s+= a[i];
    prom = s/n;
  }
  printf("%f",prom);
}

void ordena(){
  float ayuda;
  for(int i=0;i<n;i++){
    aux[i]=a[i];
  }
  for (int i=0;i<n;i++){
    for (int j = 0; j < n; j++) {
      if (aux[i]>aux[j]) {
        ayuda = aux[i];
        aux[i]= aux[j];
        aux[j]=ayuda;
      }
    }
  }
}

void menu(){
  char op = '\0';
  while (op != (char)27){
    clear();
    printf("a) Captura de valores\n");
    printf("b) Mostrar valores capturados\n");
    printf("c) Media/promedio\n");
    printf("d) Mayor\n");
    printf("e) Menor\n");
    printf("f) Mediana\n");
    printf("g) Moda\n");
    printf("h) Desciación estandar\n");
    printf("i) Menor a mayor\n");
    printf("j) Mayor a menor\n");
    printf("\n Indica la opción:");
    op = getchar();
    if (((op < 'a') || (op>'j')) &&( op != (char)27)){
      printf("Opción fuera de rango");
      getchar();
    }
    else{
      switch (op) {
        case 'a':
          captura();
          break;
        case 'b':
          muestra();
          break;
        case 'c':
          promedio();
          break;
        case 'd':
          ordena();
          break;
        case 'e':
          break;
        case 'f':
          break;
        case 'g':
          break;
        case 'h':
          break;
        case 'i':
          break;
        case 'j':
          break;
      }
    }
  }
}



int main() {
  menu();
  return 0;
}
