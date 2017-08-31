#include <stdio.h>
#include <stdlib.h>

char *server;
char *protocol;
char *port;
char *method;
char *queryString;
char *contentLength;

void obtenerVariables(){
  server = getenv("SERVER_NAME");
  protocol = getenv("SERVER_PROTOCOL");
  port = getenv("SERVER_PORT");
  method = getenv("REQUEST_METHOD");
  queryString = getenv("QUERY_STRING");
  contentLength = getenv("CONTENT_LENGTH");
}

void respuestaServer(){
  printf("Content-type: text/html\n\n");
  printf("<html>\n" );
  printf("<h2>Server name: %s</h2>",server);
  printf("<h2>SERVER_PROTOCOL: %s</h2>",protocol);
  printf("<h2>Server port: %s</h2>",port);
  printf("<h2>Server method: %s</h2>",method);
  printf("<h2>Server queryString: %s</h2>",queryString);
  printf("<h2>Server contentLength: %s</h2>",contentLength);

  printf("</html>\n" );

}

int main(int argc, char const *argv[]) {
  obtenerVariables();
  respuestaServer();
  return 0;
}
