#include "stdio.h"

int main(int argc, char const *argv[])
{
    printf("1: selecciona incremento, 2: Selcciona los intervalos: \n");
    int n = 1;
    int x, y, z;

    scanf("%d", &n);

    printf("X? ");
    scanf("%d", &x);
    printf("Y? ");
    scanf("%d", &y);
    printf("Z? ");
    scanf("%d", &z);

    if (n == 1)
    {
        for (; x < z; x += y)
        {
            printf("%d, ", x);
        }
    }
    else
    {
        for (float a = x; a < (float)z; a+=(float)(z-x)/(y-1))
        {
            printf("%f\n", a);
        }
        printf("%d\n", z);
    }
    return 0;
}
