#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include "listaEnlazada.h"
const int STARTING_SIZE = 5;

LinkedList * new_list(){
    LinkedList * list = malloc(sizeof(LinkedList));
    list->head=NULL;
    list->end=NULL;
    list->len =0 ;
    return list;
}

ListNode * new_node(void* item){
    ListNode* node = malloc(sizeof(ListNode));
    node->value = item;
    node->next = NULL;
    return node;
}

//add to the end
void append(LinkedList* list, void * item){
    list->end->next = new_node(item);
    list->end = list->end->next;
    list->len++;
}

//add to the beginning
void prepend(LinkedList* list, void * item){
    list->len++;
    ListNode * node = new_node(item);
    node->next = list->head;
    list->head = node;
}

int grow(Vector *vec){
    void* result=realloc(vec->arr,vec->capacity*2);
    if(result == NULL)
        return -1;
    vec->capacity*=2;
    return 1;
}

int push(Vector* vec, void* item){
    if(vec->capacity == vec->size)
        if(grow(vec)==-1)
            return -1;
        
    vec->arr[vec->size].value = item;
    vec->size++;
    return 1;
}

void * pop(Vector *vec){
    if(vec->size==0){
        return NULL;
    }else{
        vec->size--;
        return vec->arr[vec->size].value;
    }
}
int len(Vector * vec){
    return vec->size;
} 

Vector * newVec(){
    Vector* vec=(Vector *)malloc(sizeof(Vector));
    vec->arr= (QueueNode*)calloc(STARTING_SIZE,sizeof(QueueNode));
    vec->capacity=STARTING_SIZE;
    vec->size=0;
    return vec;
}
Vector * newVecWithCapacity(int capacity){
    Vector* vec=(Vector *)malloc(sizeof(Vector));
    vec->arr= (QueueNode*)calloc(capacity,sizeof(QueueNode));
    vec->capacity=capacity;
    vec->size=0;
    return vec;
}

void * get(Vector * vec, int index){
    if(index>vec->size||index<0)
        return NULL;
    else{
        return vec->arr[index].value;
    }
}

void destroyVec(Vector * vec){
    // for (int i = 0; i < vec->size; i++)
    // {
    //     free(vec->arr[i].value);
    // }
        free(vec->arr);
        free(vec);
}

// int main(int argc, char const *argv[])
// {
//     Vector * vec = newVec();
    
//     push(vec,3); 
//     printf("length: %d\n",len(vec));
//     printf("%d\n",(int)pop(vec));
//     for (int i = 1; i <= 10; i++)
//     {
//         if(push(vec,i*i)==-1)
//             exit(EXIT_FAILURE);
//     }
    
//     ((int)pop(vec)==100)?printf("Works\n"):printf("doesn't work\n");
//     printf("capacity %d: (should be 10)\n",vec->capacity);
//     if (push(vec,3)==-1)
//         exit(EXIT_FAILURE);
//     if (push(vec,5)==-1)
//         exit(EXIT_FAILURE);
//     printf("capacity %d: (should be 20)\n",vec->capacity);



//     exit(EXIT_SUCCESS);
    
// }
