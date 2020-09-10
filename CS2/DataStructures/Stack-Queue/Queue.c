
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct nodoQueue
{
    char nombre[20];
    
    struct nodoQueue *next;
};

FILE *archivo;
char datos[80];

struct nodoQueue *primero = NULL, *actual = NULL, *ultimo = NULL, *anterior = NULL;
//struct nodoLibro primero, actual, ultimo;

void push(char nom[]){
    actual = malloc(sizeof(struct nodoQueue));

    strcpy(actual->nombre,nom);
    if (primero==NULL)
    {
        primero = actual;
        ultimo = actual;
    }else{
        ultimo ->next = actual;
        ultimo = actual;
    }
    ultimo->next = NULL;
}

void pop(){
    if (primero == NULL)
    {
        printf("VACIO\n");
    }else
    {
        printf("ELiminado\n");
        primero = primero->next;
    }
}

void consultarQueue(){
    if (primero == NULL)
    {
        printf("Lista VACIA\n");
    }else{
        actual = primero;
        while (actual!=NULL){
            printf("%s\n",actual->nombre);
            actual = actual->next;
        }
    }
}

void opciones()
{
    int opcion;
    char name[20];

    do
    {
        printf("\n\nQueue en lenguaje c\n");
        printf("1) Push\n");
        printf("2) Pop\n");
        printf("3) Consultar Queue\n");
        printf("4) Exit\n");
        printf("Opcion = ");
        scanf("%d",&opcion);

        if (opcion == 1)
        {
            printf("Nombre:");
            fgets(name,20,stdin);
            fgets(name,20,stdin);
            push(name);
        }

        else if (opcion == 2)
        {
            pop();
        }

        else if (opcion == 3)
        {
            consultarQueue();
        }

    } while (opcion != 4);

    //datosListaArchivo();
}

int main()
{
    //datosArchivoLista();
    opciones();
}
