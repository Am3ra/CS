#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void upper_string(char s[]) {
   int c = 0;

   while (s[c] != '\0') {
      if (s[c] >= 'a' && s[c] <= 'z') {
         s[c] = s[c] - 32;
      }
      c++;
   }
}



int main(void)
{
  char nombre[20] = "Jose", ap[20] = "Escedo", mat[20]="Esparza",rfc[11];
  int nomnom = 0, ano= 1989, mes = 16, dia= 14, an2;
  char d;
  char c;
  upper_string(nombre);
  upper_string(ap);
  upper_string(mat);


  rfc[0]= ap[0];
  rfc[2] = mat[0];

  // Encontrar si tiene mas de un nombre
  for (int i = 0; i < strlen(nombre); i++) {
    d = nombre[i];
    if (strcmp(&d," ") == 0){
      nomnom = i;
      break;
    }
  }
  // Encontrar si su nombre es Jose o Maria
  int jom =0;
  if (strncmp(&nombre, "JOSE",4)==0 || strncmp(&nombre, "MARIA",5)==0){
    jom = 1;
  }
  // Encontrar la primera vocal interna paterna
  for (int i = 1; i < strlen(ap); i++) {
    c = ap[i];
    if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
      rfc[1]=ap[i];
      break;
    }
  }

  //Encontrar 4a letra rfc

  if (nomnom == 0){
    rfc[3]=nombre[0];
  } else if(jom == 0){
    rfc[3]=nombre[0];
  } else{
    rfc[3] = nombre[nomnom+1];
  }
  //primeros dos numeros
  an2 = ano %100; // ultimos 2 numeros del ano
  rfc[4] = (an2 / 10)+48;
  rfc[5] = (an2 % 10)+48;
  //segundos dos numeros
  if (mes<10){
    rfc[6] = 48;
    rfc[7] = 48 + mes;
  } else{
    rfc[6] = 49;
    rfc[7] = mes%10 + 48;
  }

  //terceros dos numeros

  if (dia<10){
    rfc[8] = 48;
    rfc[9] = 48 + dia;
  } else{
    rfc[8] = dia/10 +48;
    rfc[9] = dia%10 + 48;
  }


  printf("%s\n",rfc );


  return 0;
}
