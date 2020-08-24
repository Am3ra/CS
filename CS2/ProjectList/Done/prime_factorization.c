#include <stdio.h>
//DONE
void primeFactorization();

int main(int argc, char const *argv[])
{
    primeFactorization();
    return 0;
}

void primeFactorization(){
    int input;
    printf("Enter number to be factorized:\n");
    scanf("%d",&input);
    printf("The prime factorization of %d is:\n",input);

    while(input > 1){
        for(int i = 2; i<=input; i++){
            if (input%i==0) {
                input /= i;
                printf("%d, ",i);
                break;
            }
            
        }
    }
    printf("\n");
}