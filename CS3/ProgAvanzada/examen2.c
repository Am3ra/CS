#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <inttypes.h>

typedef struct{
    float angulo;
    int16_t x;
    int16_t y;
    u_int8_t tipo; 
}Minucia;

typedef struct{
    Minucia * minucias;
    u_int16_t longitud;
}ArregloMinucias;

Minucia * crearMinucia( float angulo, int16_t x, int16_t y, u_int8_t tipo){
    Minucia * min = calloc(1,sizeof(Minucia));
    min->angulo=angulo;
    min->x=x;
    min->y=y;
    min->tipo=tipo;
    return min;
}

ArregloMinucias * crearArregloMinucias(u_int16_t size){
    ArregloMinucias * arr = calloc(1,sizeof(ArregloMinucias));
    arr->minucias = calloc(1,sizeof(Minucia));
    arr->longitud = size;
    return arr;
}

void liberarArregloMinucias(ArregloMinucias * minucia){
    free(minucia->minucias);
}

double calcularDistancia(Minucia * minucia,Minucia * minucia2){
    return sqrt(pow(minucia->x-minucia2->x,2)+pow(minucia->y-minucia2->y,2));
}

Minucia * encontrarCentroide(ArregloMinucias * minucias){
    double min = __DBL_MAX__;
    u_int16_t index=0;
    for (u_int16_t i = 0; i < minucias->longitud; i++)
    {
        double total=0;
        for (u_int16_t j = 0; j < minucias->longitud; j++)
        {
            if(i==j)
                continue;
            total += calcularDistancia( &(minucias->minucias[i]),&(minucias->minucias[j]));
        }
        if (total < min)
        {
            min = total;
            index = i;
        }
        
    }
    return &(minucias->minucias[index]);
}

const char * devolverTipoMinucia(Minucia*minucia){
    switch (minucia->tipo)
    {
    case 0:
        return "TERMINACION";
    case 1:
        return "DIVISION";
    case 2:
        return "PUNTO";
    case 3:
        return "DESCONOCIDO";
    default:
        break;
    }
    return NULL;
}

void imprimirMinucia(Minucia * min){
    printf("Angulo:%8f, pos: (%u,%u), tipo:%s\n",min->angulo,min->x,min->y,devolverTipoMinucia(min));
}

int main(int argc, char const *argv[])
{
    ArregloMinucias * arr = crearArregloMinucias(5); // probar crear arreglo
    for (int i = 0; i < 10; i++)
        arr->minucias[i] = *crearMinucia(16.3,i,i,01); //Probar Crear Minucia

    //Se prueba encontrar centroide, calcularDistancia, devolvertipo, imprimir
    imprimirMinucia(encontrarCentroide(arr));
    
    //Se prueba liberar arreglo Minucias.
    liberarArregloMinucias(arr);

    return EXIT_SUCCESS;
}
