#include <stdio.h>
#include <math.h>
#include <stdlib.h>


typedef struct point
{
    int x;
    int y;
} Point;

float POINTdist(Point a, Point b){
    return sqrt(pow(a.x - b.x,2) +  pow(a.y - b.y,2));
}


char * closestPair(Point a[], int size){
    int first, second;
    float dist = 999999;
    for (int i = 0; i < size-1; i++)
    {
        for (int j = i+1; j < size; j++)
        {
            if(POINTdist(a[i],a[j])<dist){
                first = i;
                second = j;
                dist = POINTdist(a[i],a[j]);
            }
        }
        
    }

    char *buffer = (char*)malloc(50 * sizeof(char));

    snprintf(buffer,50,"Pair: %d,%d\nDist: %f\n",first,second,dist);
    return buffer;
    
}

float avgDist(Point a[], int size){
    int count=0,sum;
    for (int i = 0; i < size-1; i++)
    {
        for (int j = i+1; j < size; j++)
        {
            count++;
            sum += POINTdist(a[i],a[j]);
        }
        
    }

    
    return (float)sum/count;
    
}

int main(int argc, char const *argv[])
{
    FILE *fp = fopen("test.txt", "r");
    int size;

    if(fp == NULL)
    {
        printf("Error opening file\n");
        exit(1);
    }

    if(fscanf(fp,"%d",&size)!= EOF)
        printf("Size: %d\n",size);
 
    Point arr[size];
    for (int i = 0; i < size; i++)
    {
        Point temp;
        fscanf(fp,"%d %d",&(temp.x),&(temp.y));
        arr[i] = temp;
    }

    for (int i = 0; i < size; i++){
        printf("%d %d\n", arr[i].x,arr[i].y);
    }

    printf("%s",closestPair(arr,size));
    printf("average distance: %f\n",avgDist(arr,size));
    
    
    
    return 0;
}
