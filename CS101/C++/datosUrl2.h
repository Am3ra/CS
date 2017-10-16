#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 10

char *arregloTokens[N];
char *variables[N];
char *valores[N];
int  nt=0;

char *obtenerUrlString()
{
    char *metodo;
    char *stringUrl;
    
    // 1. Obtener el método de conexión, GET o POST
    metodo = getenv("REQUEST_METHOD");
    
    // 2. Checar el método
    // Si el métdo es GET
    if(strcmp(metodo,"GET") == 0)
    {
        // Obtener el URL String a través de la Variable de Entorno QUERY_STRING
        stringUrl = getenv("QUERY_STRING");
    }
    // Sino
    else
    {
        // Obtener el URL String a través de la Variable de Entorno CONTENT_LENGTH
        stringUrl = getenv("CONTENT_LENGTH");
        scanf("%s",stringUrl);
    }
    
    // 3. Entregar al URL String
    
    return stringUrl;
}

void obtenerVariablesValores(char *stringUrl)
{
    char *token;
    int  i=0;
    int k=0;
    
    //1. Obtener los Tokens de quitar el delimitador “&” y ponerlos en un arreglo de tokens
    token = strtok(stringUrl,"&");
    while(token != NULL && nt < N)
    {
        arregloTokens[nt] = token;
        
        token = strtok(NULL,"&");
        
        nt++;
    }
    
    //2. Obtener las variables y los valores quitando el delimitador “=” de cada Token y asignarlos al arreglo correspondiente
    token = strtok(arregloTokens[i],"=");
    while(token != NULL && i<nt)
    {
        variables[i] = token;
        
        token = strtok(NULL,"=");
        
        for(k=0; k<strlen(token); k++)
            if(token[k] == '+')
                token[k] = ' ';
            
        
        valores[i] = token;
        
        i++;
        token = strtok(arregloTokens[i],"=");
    }

}

char *getParameter(char *param)
{
    int i=0;
    int encontrado=0;
    char *valor;
    
    while(i<nt && encontrado == 0)
    {
        if(strcmp(param,variables[i]) == 0)
        {
            valor = valores[i];
            encontrado = 1;
        }
        
        i++;
    }
    
    if(encontrado == 0)
        valor = "No se localizo el parametro...";
    
    return valor;
}

void obtenerParametros()
{
    char *urlString;
    
    // 1. Obtener el URL String del URL Encoding de acuero al método d conexión: GET o POST
    urlString = obtenerUrlString();
    //desplegar(urlString);
    
    // 2. Obtener los parámetros o variables, y los valores del URL String almacenándolos en una Estructura de Datos (Arreglo, Vector, Linked List)
    obtenerVariablesValores(urlString);
    //desplegarArregloTokens();
}











