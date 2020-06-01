#include <stdio.h>
#include <omp.h>

typedef struct
{
    float * valores;
    int filas;
    int columnas;
}Matriz;

Matriz* newMatriz(int filas, int columnas){
    Matriz *temp = calloc(1,sizeof(Matriz));
    temp->columnas=columnas;
    temp->filas = filas;
    temp->valores = calloc(1,sizeof(float)*columnas*filas);
    return temp;
}

float matrixGet(Matriz* matrix,int a, int b){
    if(a>=matrix->filas || b >= matrix->columnas){
        printf("ERROR, OUT OF BOUNDS");
        exit(EXIT_FAILURE);
    }
    return matrix->valores[a*matrix->columnas + b];
}

void matrixSet(Matriz* matrix,int a, int b, float val){
    if(a>=matrix->filas || b >= matrix->columnas){
        printf("ERROR, OUT OF BOUNDS");
        exit(EXIT_FAILURE);
    }
    matrix->valores[a*matrix->columnas + b] = val;
}

Matriz* Multiplicar(Matriz* matriz1, Matriz *matriz2){
    if (matriz1->columnas != matriz2->filas)
        return NULL;
    
    Matriz * new = newMatriz(matriz1->filas,matriz2->columnas);

    #pragma parallel for
    for (int i = 0; i < matriz1->filas; i++)
    {
        #pragma parallel for
        for (int j = 0; j < matriz2->columnas; j++)
        {
            int sum = 0;
            #pragma parallel for reduction (+ : sum)
            for (int k = 0; k < matriz1->columnas; k++)
            {
                sum+= matrixGet(matriz1,i,k)*matrixGet(matriz2,k,j);
            }

            matrixSet(new,i,j,sum);
        }
    }

    return new;
}

Matriz* Transpuesta(Matriz* matriz){
    Matriz * temp = newMatriz(matriz->filas,matriz->columnas);

    #pragma omp parallel for
    for (int i = 0; i < matriz->filas; i++)
    {
        
        #pragma omp parallel for
        for (int j = 0; j < matriz->columnas; j++)
        {
           matrixSet(temp,j,i,matrixGet(matriz,i,j));
        }
    }
    return temp;
}

float* SumarFilas(Matriz* matriz){
    float *suma = calloc(matriz->filas,sizeof(float));

    #pragma omp parallel for
    for (int i = 0; i < matriz->filas; i++)
    {
        int x = 0;

        #pragma parallel for reduction (+ : x)
        for (int j = 0; j < matriz->columnas; j++)
        {
            x+=matrixGet(matriz,i,j);
        }
        
        suma[i] = x;
    }

    return suma;
}

float* SumarColumnas(Matriz* matriz){
    float *suma = calloc(matriz->columnas,sizeof(float));

    #pragma omp parallel for
    for (int i = 0; i < matriz->columnas; i++)
    {
        int x = 0;

        #pragma parallel for reduction (+ : x)
        for (int j = 0; j < matriz->filas; j++)
        {
            x+=matrixGet(matriz,j,i);
        }
        
        suma[i] = x;
    }

    return suma;
}

Matriz* Broadcasting(Matriz* matriz){
    

    //copiar columnas
    if (matriz->columnas == 1){
        Matriz * temp = newMatriz(matriz->filas,matriz->filas);
        #pragma parallel for
        for (int i = 0; i < temp->filas; i++)
        {
            #pragma parallel for
            for (int j = 0; j < temp->columnas; j++)
            {
                matrixSet(temp,i,j,matrixGet(matriz,i,0));
            }
            
        }

        return temp;
        
    }
    //copiar filas
    else if (matriz->filas == 1){
        Matriz * temp = newMatriz(matriz->columnas,matriz->columnas);
        #pragma parallel for
        for (int i = 0; i < temp->columnas; i++)
        {
            #pragma parallel for
            for (int j = 0; j < temp->filas; j++)
            {
                matrixSet(temp,j,i,matrixGet(matriz,0,i));
            }
            
        }

        return temp;
        
    }else{
        return NULL;
    }
}

void printMatrix(Matriz * a){
    if(a)
    for (int i = 0; i < a->filas; i++)
    {
        for (int j = 0; j < a->columnas; j++)
        {
            printf("%f ", matrixGet(a,i,j));
        }
        printf("\n");
    }
    else
        printf("NULL PRINT");
    
    printf("\n");
}

int main(int argc, char const *argv[])
{
    Matriz * a = newMatriz(2,2);
    Matriz * b = newMatriz(2,2);
    Matriz * c = newMatriz(2,1);
    Matriz * d = newMatriz(1,2);
    
    //matriz identidad 2x2
    matrixSet(a,0,0,2);
    matrixSet(a,1,1,2);

    matrixSet(b,0,0,1);
    matrixSet(b,0,1,2);
    matrixSet(b,1,0,3);
    matrixSet(b,1,1,4);

    matrixSet(c,0,0,3);
    matrixSet(c,1,0,2);

    matrixSet(d,0,0,2);
    matrixSet(d,0,1,3);

    printMatrix(c);
    printMatrix(Broadcasting(c));
    printMatrix(d);
    printMatrix(Broadcasting(d));

    printMatrix(b);

    float * suma = SumarFilas(b);
    for (int i = 0; i < b->filas; i++)
    {
        printf("%f \n",suma[i]);
    }

    printf("\n");

    float * suma2 = SumarColumnas(b);
    for (int i = 0; i < b->columnas; i++)
    {
        printf("%f ",suma2[i]);
    }

    printf("\n");
    printf("\n");

    printMatrix(Transpuesta(b));
    printMatrix(Multiplicar(a,b));
    return 0;
}
