#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n){
    if(n<=1){
        return 1;
    }
    return fibonacci(n-1)+fibonacci(n-2);
}

int main(int argc, char *argv[])
{
    

    int sum =0;

    #pragma omp parallel for reduction (+ : sum)
    for (int i = 0; i < 11; i++)
    {
       sum += fibonacci(i);
    }

    printf("%d\n",sum);
    
} /* All threads join master thread and disband */
