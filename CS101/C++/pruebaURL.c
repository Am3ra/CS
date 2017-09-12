#include <stdio.h>
#include <string.h>

char *imagen, *boton;
void respuestaServer(char *urlString){

  printf("Content-type: text/html\n\n");
  printf("<html>\n" );

  printf("<h2>URL String: %s</h2>\n",urlString);

  printf("</html>\n" );


}

void obtenerValores(char *stringUrl){
  char *tokenImagen, *tokenBoton;
  int i=0;


  tokenImagen = strtok(stringUrl, "&");
  tokenBoton = strtok(NULL, "&");
  imagen = strtok(tokenImagen, "=");
  imagen = strtok(NULL, "=");
  boton = strtok(tokenBoton, "=");
  boton = strtok(NULL, "=");
  while (i<strlen(imagen)) {
    if (imagen[i]=="+") {
      imagen[i] = " ";
    }
    i++;
  }
}

int main() {
  char *method,*urlString;
  method = getenv("REQUEST_METHOD");

  if(strcmp(method, "GET")==0){
    urlString = getenv("QUERY_STRING");
  } else{
    urlString = getenv("CONTENT_LENGTH");
    scanf("%s",urlString);
  }

  respuestaServer(urlString);


  return 0;
}
