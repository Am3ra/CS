#include <stdio.h>
#include <stdlib.h>

char *queryString;
int a;
long b,x,e;

int exponencial(long x, long b) {
  int i;
  e=1;
  if (x>0){
    a=0;
  }
  else if(x<0) {
    a=1;
    x =  abs(x);
  }
  else if (x==0){
    a=2;
  }
  for (i=0;i<x;i++){
    e *= b;
  }
  return e;
}


void obtenerVariables(){
  queryString = getenv("QUERY_STRING");
  sscanf(queryString,"b=%ld&x=%ld",&b,&x);
}




void respuestaServer(long x, long b, long e){
  printf("Content-type: text/html\n\n");
  printf("<html>\n" );
  printf("<h1>Funcion exponencial Y = B ^ X <h1>\n");
  if (a==0){
    printf("<h2>Funcion exponencial Y= %ld ^ %ld = %ld\n",b,x,e);
  } else if (a==1){
    printf("<h2>Funcion exponencial Y= %ld ^ %ld = 1/%ld\n",b,x,e);
  } else if (a== 2){
    printf("<h2>Funcion exponencial Y= %ld ^ 0 = 1",b);
  }
  printf("</html>\n" );
}



int main() {
  obtenerVariables();
  e = exponencial(x,b);
  respuestaServer(x,b,e);
  return 0;
}
