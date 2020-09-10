#include <stdio.h>

#define clear() printf("\033[H\033[J")
#define gotoxy(x,y) printf("\033[%d;%dH", (x), (y))


char mat[5],nom[31],ap[31],car[5],cor[31];

int c1, c2, c3;

float prom;


void altas(){
  clear();
  printf("indica la matrícula");
  gets(mat);
  printf("indica el nombre");
  gets(nom);
  printf("indica el Ap. Paterno");
  gets(ap);
  printf("indica la carrera");
  gets(car);
  printf("indica el correo");
  gets(cor);
  printf("indica la calif 1");
  scanf("%d\n", c1);
  printf("indica la calif 2");
  scanf("%d\n", c2);
  printf("indica la calif 3");
  scanf("%d\n", c3);

  prom =(c1+c2+c3)/3.0;

}

void capturar(char *datos)
{
    // 1. Obtener datos
    //obtenerDatos();

    // 2. Abrir archivo para escribir o guardar los datos
    archivo = fopen("Libros.txt","a");

    // 3. escribir o guardar los datos en el archivo
    fputs(datos,archivo);

    // 4. Cerrar archivo
    fclose(archivo);
}
