#pragma once

/*
Singly Linked- Linked list node
*/
typedef struct single_node
{
    void *data;
    struct single_node *next;
} sNode;

/*
Doubly Linked- Linked list node
*/
typedef struct double_node
{
    void *data;
    struct double_node *next;
    struct double_node *prev;
} Node;

sNode * CreateSNode(void * value);

Node * CreateNode(void * value);

sNode * deleteSNode(sNode * node);

Node * deleteNode(Node * node);

void deleteSList(sNode *head, int type);

void deleteList(Node *head);

int *MakeInt(int value);

void PrintList(Node *head, void (*func)(Node *));