#include "stdio.h"

int main(int argc, char const *argv[])
{
    int n;
    printf("n: ");
    scanf("%d",&n);

   for (int i = 1; i <= n; i++)
   {
        for (int j=n-i; j>0; j--)
        {
            printf(" ");
        }
        for (int j = 1; j <= i ; j++)
        {
            printf("* ");
        }
        printf("\n");
   }
   
    

    /* code */
    return 0;
}
