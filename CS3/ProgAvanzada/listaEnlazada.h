#pragma once

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


typedef struct listnode{
    void* value;
    struct listnode * next;
}ListNode;

typedef struct linkedList{
    ListNode* head;
    ListNode* end;
    int len;
    
}LinkedList;

typedef struct {
    void* value;
} QueueNode;

typedef struct
{
    QueueNode* arr;
    int capacity;
    int size;
}Vector;

LinkedList * new_list();

ListNode * new_node(void* item);

//add to the end
void append(LinkedList* list, void * item);

//add to the beginning
void prepend(LinkedList* list, void * item);

int grow(Vector *vec);

int push(Vector* vec, void* item);

void * pop(Vector *vec);

int len(Vector * vec);

Vector * newVec();

void * get(Vector * vec, int index);

void destroyVec(Vector * vec);

Vector * newVecWithCapacity(int capacity);

