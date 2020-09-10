#include "listaEnlazada.h"
#include <stdio.h>

typedef struct{
    Vector * vec;
    int size_x;
    int size_y;
}Matrix;

typedef struct{
    int x;
    int y;
    int height;
    int width;
}Rec;

Matrix * newMatrix(int x, int y){
    Matrix * mat = malloc(sizeof(Matrix));

    mat->vec = newVecWithCapacity(y);
    for (int i = 0; i < y; i++)
    {
        mat->vec->arr[i].value = newVecWithCapacity(x);
    }

    mat->size_x=x;
    mat->size_y=y;

    return mat;
}

void * getIndex(Matrix * mat, int y, int x){
    if(mat==NULL)
        return NULL;
    if(x<0||y<0){
        return NULL;
    }
    if(x>=mat->size_x || y>=mat->size_y){
        return NULL;
    }

    return ((Vector *)(mat->vec->arr[y].value))->arr[x].value;
}

//returns 0 if error, 1 if not
int setIndex(Matrix * mat, int y, int x, void * val){
    if(mat==NULL)
        return 0;
    if(x<0||y<0){
        return 0;
    }
    if(x>=mat->size_x || y>=mat->size_y){
        return 0;
    }

    ((Vector *)(mat->vec->arr[y].value))->arr[x].value = val;

    return 1;
}

void printMat(Matrix * mat){
    if(mat==NULL)
        return;
    for (int i = 0; i < mat->size_y; i++)
    {
        for (int j = 0; j < mat->size_x; j++)
        {
            printf("%d " ,getIndex(mat,i,j));
        }
        printf("\n");
    }
    printf("\n");
}

void destroyMat(Matrix * mat){
    if(mat==NULL)
        return;
    for (int i = 0; i < mat->size_y; i++)
    {
        destroyVec(mat->vec->arr[i].value);
    }
    destroyVec(mat->vec);
    free(mat);
}

Matrix * addMats(Matrix * mat1, Matrix * mat2){
    if(mat1->size_x!=mat2->size_x || mat1->size_y!=mat2->size_y){
        return NULL; //Matrices de tamaño diferente. 
    }

    Matrix * resultado = newMatrix(mat1->size_x,mat1->size_y);

    for (int i = 0; i < mat1->size_y; i++)
    {
        for (int j = 0; j < mat1->size_x; j++)
        {
            setIndex(resultado,i,j,(int)getIndex(mat1,i,j)+(int)getIndex(mat2,i,j));
        }
        
    }

    return resultado;
}


void swapVec(Vector*vec,int i, int j){
    void* temp = vec->arr[i].value;
    vec->arr[i].value=vec->arr[j].value;
    vec->arr[j].value=temp;
}

void orderVec(Vector*vec){
    if(vec==NULL)
        return;
    for (int i = 0; i < vec->size; i++)
        for (int j = i; j > 0 && vec->arr[j-1].value > vec->arr[j].value ; j--)
            swapVec(vec,j,j-1);   
}

void printVec(Vector*vec){
    for (int i = 0; i < vec->size; i++)
    {
        printf("%d, ",(int)vec->arr[i].value);
    }
    printf("\n");
}

void invertVec(Vector*vec){
    for (int i = 0; i < vec->size/2-1; i++)
        swapVec(vec,i,vec->size-1-i);
    
}

Rec * newRec(int x, int y, int height, int width){
    Rec * new = calloc(1,sizeof(Rec));
    new->height=height;
    new->width=width;
    new->x=x;
    new->y=y;
    return new;
}

Rec* recIntersect(Rec*rec1,Rec*rec2){
    //Uno esta encima completamente
    if(rec1->height+rec1->y < rec2->y || rec2->height+rec2->y < rec1->y)
        return NULL;
    if(rec1->width+rec1->x < rec2->x || rec2->width+rec2->x < rec1->x)
        return NULL;

    int x,y,width,height;
    if(rec1->x > rec2->x)
        x = rec1->x;
    else
        x = rec2->x;

    if(rec1->y > rec2->y)
        y = rec1->y;
    else
        y = rec2->y;


    if(rec1->x+rec1->width > rec2->x+rec2->width)
        width = rec2->x+rec2->width - x;
    else
        width = rec1->x+rec1->width - x;

    if(rec1->y+rec1->height > rec2->y+rec2->height)
        height = rec2->y+rec2->height - y;
    else
        height = rec1->y+rec1->height - y;

    return newRec(x,y,height,width);
    
}

void printRec(Rec*rec){
    if(rec==NULL)
        return;
    printf("Width: %d, height: %d, (%d,%d)",rec->width,rec->height,rec->x,rec->y);
}


int main(int argc, char const *argv[])
{
    Matrix*mat1 = newMatrix(2,2);
    Matrix*mat2 = newMatrix(2,2);
    setIndex(mat1,1,1,1);
    setIndex(mat2,0,0,1);
    printMat(mat1);
    printMat(mat2);

    Matrix*mat3 = addMats(mat1,mat2);
    printMat(mat3);
    destroyMat(mat1);
    destroyMat(mat2);
    destroyMat(mat3);

    Vector * vec= newVecWithCapacity(10);
    for (int i = 9; i >= 0; i--)
    {
        push(vec, (void *) i);
    }

    printVec(vec);
    orderVec(vec);
    printVec(vec);
    invertVec(vec);
    printVec(vec);

    destroyVec(vec);

    Rec * rec = newRec(0,0,10,10);
    Rec * rec2 = newRec(-2,-2,10,10);
    Rec * rec3 = recIntersect(rec,rec2);
    
    printRec(rec3);

    free(rec);
    free(rec2);
    free(rec3);

    return 0;
}
