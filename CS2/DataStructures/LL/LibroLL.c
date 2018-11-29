
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct nodoLibro
{
    char titulo[20];
    char autor[20];
    char editorial[20];

    struct nodoLibro *next;
};

FILE *archivo;
char datos[80];

struct nodoLibro *primero = NULL, *actual = NULL, *ultimo = NULL, *anterior = NULL;
//struct nodoLibro primero, actual, ultimo;

void obtenerDatos()
{
    printf("TITULO: ");
    gets(actual->titulo);
    gets(actual->titulo);

    printf("AUTOR: ");
    gets(actual->autor);

    printf("EDITORIAL: ");
    gets(actual->editorial);

    printf("Datos nodo: %s   %s   %s", actual->titulo, actual->autor, actual->editorial);
}

/*void obtenerDatos()
{
    printf("TITULO: ");
    gets(actual.titulo);
    gets(actual.titulo);
    
    printf("AUTOR: ");
    gets(actual.autor);
    
    printf("EDITORIAL: ");
    gets(actual.editorial);
    
    printf("Datos nodo: %s   %s   %s", actual.titulo, actual.autor, actual.editorial);
}*/

void capturarDatos()
{
    actual = malloc(sizeof(struct nodoLibro));

    obtenerDatos();

    // creacion de nodos tipo struct
    if (primero == NULL)
    {
        primero = actual;
        ultimo = actual;
        ultimo->next = NULL;

        printf("\nPrimer Nodo Libro creado...");
    }
    else
    {
        ultimo->next = actual;
        ultimo = actual;
        ultimo->next = NULL;

        printf("\nNuevo Nodo Libro creado...");
    }
}

void consultarLibros()
{
    int i = 1;

    if (primero == NULL)
        printf("Lista vacia...");
    else
    {
        actual = primero;

        while (actual != NULL)
        {
            printf("\n%s   %s   %s", actual->titulo, actual->autor, actual->editorial);

            actual = actual->next;
            i++;
        }
    }
}

void consultarEditorial()
{
    char edit[20];
    int encontrado = 0;

    if (primero == NULL)
        printf("Lista vacia...");
    else
    {
        printf("\nEditorial a consultar: ");
        gets(edit);
        gets(edit);

        actual = primero;

        while (actual != NULL)
        {
            //if(edit == actual->editorial)
            if (strcmp(edit, actual->editorial) == 0)
            {
                printf("\n%s   %s   %s", actual->titulo, actual->autor, actual->editorial);

                encontrado = 1;
            }

            actual = actual->next;
        }

        if (encontrado == 0)
            printf("\nNo se localizo la editorial: %s", edit);
    }
}

int encuentras(char titulo[])
{
    int encontrado = 0;
    actual = primero;
    while (actual != NULL && encontrado == 0)
    {

        if (strcmp(titulo, actual->titulo) == 0)
        {
            encontrado++;
        }
        else
        {
            anterior = actual;
            actual = actual->next;
        }
    }
    return encontrado;
}

void consultarTitulo()
{
    char tit[20];

    if (primero == NULL)
        printf("Lista vacia...");
    else
    {
        printf("\nTitulo a consultar: ");
        gets(tit);
        gets(tit);

        if (encuentras(tit) == 1)
        {
            printf("\nDatos Anterior: %s   %s   %s", anterior->titulo, anterior->autor, anterior->editorial);
            printf("\nDatos: %s   %s   %s", actual->titulo, actual->autor, actual->editorial);
        }
        else
            printf("No se localizo el titulo del libro: %s", tit);
    }
}

void eliminarNodo(){
    actual = primero;
    if (actual == primero) {
        primero = primero->next;
    }else if(actual == ultimo){
        ultimo = anterior;
    }
    else{
        anterior->next = actual->next;
    }
    free(actual);
}

void eliminarLibro()
{
    char tit[20];

    if (primero == NULL)
        printf("Lista vacia...");
    else
    {
        printf("\nTitulo a eliminar: ");
        gets(tit);
        gets(tit);

        if (encuentras(tit) == 1)
        {
            printf("\nDatos: %s   %s   %s", actual->titulo, actual->autor, actual->editorial);

            eliminarNodo();

            printf("\nNodo eliminado...\n");
        }
        else
            printf("No se localizo el titulo del libro: %s", tit);
    }
}

void opciones()
{
    int opcion;

    do
    {
        printf("\n\nBIBLIOTECA TEC\n");
        printf("1) Capturar datos\n");
        printf("2) Consultar Libros\n");
        printf("3) Consultar Editorial\n");
        printf("4) Consultar Titulo\n");
        printf("5) Eliminar Libro por Titulo\n");
        printf("7) Exit\n");
        printf("Opcion = ");
        scanf("%d", &opcion);

        if (opcion == 1)
        {
            capturarDatos();
        }

        if (opcion == 2)
        {
            consultarLibros();
        }

        if (opcion == 3)
        {
            consultarEditorial();
        }

        if (opcion == 4)
        {
            consultarTitulo();
        }

        if (opcion == 5)
        {
            eliminarLibro();
        }

    } while (opcion != 7);

    //datosListaArchivo();
}

int main()
{
    //datosArchivoLista();
    opciones();
}
