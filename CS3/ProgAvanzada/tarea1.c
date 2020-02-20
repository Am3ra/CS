#include "stdio.h"

void printAsterisks(int a){
    for (int i = 0; i < a; i++)
    {
        printf("*");
    }
    printf("\n");

}

int main(int argc, char const *argv[])
{
    printf("Enter numb: ");
    int n;
    scanf("%d",&n);
    printHex();
    printAsterisks(n);
    return 0;
}

void printHex(){
    printf(
"
  ___
 /
/
-\"-\'-\"-\'-\"-  

"

);
}