#include <stdio.h>

void QuickSort(int a[], int size){
    int pivot = a[0];
    int left[size-1];
    int leftSize = 0 ;
    int right[size-1];
    int rightSize = 0;

    if (!size||size==1)
    {
        return;
    }
    

    for (int i = 1; i < size; i++)
    {
            if (a[i]<pivot)
            {
                left[leftSize] = a[i];
                leftSize++;
            }else{
                right[rightSize] = a[i];
                rightSize++;
            }
            
    }

    QuickSort(&left,leftSize);
    QuickSort(&right,rightSize);

    for (int i = 0; i < leftSize; i++)
    {
        a[i] = left[i];
    }

    a[1+leftSize] = pivot;

    for (int i = 0; i < size; i++)
    {
        a[i+1+leftSize] = right[i];
    }
}


int main(int argc, char const *argv[])
{
    unsigned int size;

    printf("Tamanho: ");
    scanf("%u",&size);

    unsigned int a[size];
    for (int i = 0; i < size; i++)
        scanf("%u",&a[i]);
    
    printf("Elements of the array:\n");

    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < a[i]; j++)
        {
            printf("*");
        }
        
        printf("\n");
    }

    QuickSort(a,size);
    
    for (int i = 0; i < size; i++)
    {
        printf("%d \n",a[i]);
    }
    

    return 0;
}

