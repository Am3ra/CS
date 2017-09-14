#include <stdio.h>
#include <stdlib.h>
char *queryString;
int a;
long b,x,e ;
int grados(long b, long x) {
  e=1;
  if (x==0){
    e = (b * 1.8 ) + 32;
  }
  else{
    e = (b - 32) * .5556;
  }
  return e;
}
void obtenerVariables(){
  queryString = getenv("QUERY_STRING");
  sscanf(queryString,"b=%ld&%ld=",&b,&x);
}
void respuestaServer(long x, long b){
  printf("Content-type: text/html\n\n");
  printf("<html>\n" );
  printf("<h1>Conversion de grados: <h1>\n");
  if (x==0){
    printf("%ld Grados centigrados = %ld Grados Farenheit\n",b,e );
  }else {
    printf("%ld Grados Farenheit = %ld Grados centigrados\n",b,e );
  }
  printf("</html>\n" );
}
int main() {
  obtenerVariables();
  e = grados(b,x);
  respuestaServer(x,b);
  return 0;
}
