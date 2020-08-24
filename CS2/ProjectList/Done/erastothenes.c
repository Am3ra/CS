#include <stdio.h>
#include <stdlib.h>
#include "../LinkedList.h" //change depending on file location
//DONE! Interesting things... function pointers!

void nPrimes(int n), printNode(Node *node);


int main(int argc, char const *argv[])
{
    int n;
    printf("Find primes of first N numbers\n");
    printf("N = ");
    scanf("%d",&n);
    // printf("READ NUMBER: %d\n",n);
    nPrimes(n);
    return 0;
}

void printNode(Node *node){
    static int i = 0;
    printf("The %3d prime is: %d\n",i+1, *(int*)node->data);
    i++;
}

void nPrimes(int n){

    //Is it better to save the value as an address?
    Node * head = CreateNode(MakeInt(2)); 
    Node * cursor = head,*cursor2;
    printf("ENTERED\n");

    // Populate Linked list with n numbers
    for(int i = 3; i <= n; i++)
    {
        cursor->next = CreateNode(MakeInt(i));
        cursor = cursor->next;
    }
    cursor = head;
    // PrintList(cursor,&printNode);
    
    while(cursor){
        cursor2 = cursor;
        while(cursor2->next){//Necesarily exists
            // printf("%d %d\n", *(int *)cursor2->next->data, *(int *)cursor->data);
            if (*(int *)cursor2->next->data % *(int *)cursor->data == 0)
            {
                // printf("YES %d %d\n", *(int *)cursor2->next->data, *(int *)cursor->data);
                // printf("NEWLIST\n");
                cursor2->next = deleteNode(cursor2->next);
                // PrintList(head, &printNode);
            }
            cursor2 = cursor2->next;
            if (cursor2 == NULL)
                break;
        }
        cursor = cursor->next;
    }
    PrintList(head,printNode);
    deleteList(head);
}