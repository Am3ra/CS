#include <stdio.h>
#include <stdlib.h>
//DONE


typedef struct nextPrime
{
    struct nextPrime *next;
    int current;
}Primes;

Primes * CreateNode(int value), *findNextPrime(Primes *head,Primes *last);
int checkPrime(Primes *head, int value);

int main(int argc, char const *argv[])
{
    char c;
    Primes *head = CreateNode(2);
    Primes *last = head;

    printf("The first prime is 2\n");
    while(1){
        printf("Do you want the next? (y,n)\n");//Need to validate inputs
        
        c = getchar();
        getchar();

        if (c != 'y')
        {
            printf("\n\nGOODBYE!\n");
            break;
        }
        last = findNextPrime(head,last);
    }
    
    return 0;
}

Primes* CreateNode(int value){
    Primes *current = calloc(1, sizeof(Primes));
    current ->current = value;
    current-> next = NULL;
    return current;
}

Primes* findNextPrime(Primes *head,Primes *last){
    int current = last->current +1;
    while(!checkPrime(head, current)){
        current++;
    }
    printf("Next Prime is: %d\n",current);
    last = last->next = CreateNode(current);
    return last;
}

int checkPrime(Primes *head, int value){
    Primes *cursor = head;
    while (cursor){
        if(value % cursor->current == 0)
            return 0;
        cursor = cursor->next;
    }
    return 1;
}