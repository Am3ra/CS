#include <stdio.h>
#include <string.h>

char rfc(char nom[12], char ap[21], char mat[22]){
  char rfc[11];
  rfc[0]= ap[0];
  rfc[2] = mat[0];
  char c;
  int nomnom = 0;

  for (int i = 0; i < strlen(nom); i++) {

    if (strcmp(&nom[i]," ")==0){
      nomnom=i;
    }
  }

  for (int i = 1; i < strlen(ap); i++) {
    c = ap[i];
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
      rfc[1]=ap[i];
      break;
    }
  }

  if (strcmp(nom,"Jose")==0||strcmp(nom,"Jose")){

  }

  return rfc;
}

int main() {
  printf("COOL!\n" );
  return 0;
}
