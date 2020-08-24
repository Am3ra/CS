#include <stdio.h>
int factorial(int a){
    if (a<=1){
        return 1;
    }else{
        return a * factorial(a-1);
    }
}
int main(int argc, char const *argv[])
{
    unsigned int start;
    printf("Conjetura Collatz: ");
    scanf("%u",&start);
    printf("%u\n",start);

    while (start!=1 && start)
    {
        if (!(start%2))
        {
            start/=2;
            printf("%u\n",start);
        }else{
            start= start*3 + 1;
            printf("%u\n",start);
        }
        
    }
    printf("Pascal Triangle: ");
    scanf("%u",&start);
    for (int i = 0; i < start; i++)
    {
        for (int j = 0; j < start-i; j++)
        {
            printf(" ");
        }
        
        for (int j = 1; j <= i+1; j++)
        {
            printf("%d " ,factorial(i)/(factorial(i-j+1)*factorial(j-1)));
        }
        printf("\n");
        
    }
    return 0;
}
