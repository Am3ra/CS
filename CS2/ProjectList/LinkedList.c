#include <stdlib.h>
#include "LinkedList.h"



/**
 * @brief  Create Singly Linked list node
 * @param  value: Value contained in node
 * @retval pointer to node
 */
sNode * CreateSNode(void * value){
    sNode * temp = calloc(1, sizeof(sNode));
    temp ->data = value;
    temp ->next = NULL;
    return temp;
}

/**
 * @brief  Create double linked list Node with value
 * @param  value: value of node
 * @retval pointer to node
 */
Node * CreateNode(void * value){
    Node * temp = calloc(1, sizeof(Node));
    temp ->data = value;
    temp ->next = NULL;
    temp ->prev = NULL;
    return temp;
} 

// Delete sNode

sNode * deleteSNode(sNode * node){
    sNode * temp = node ->next;
    free(node->data);
    free(node);
    return temp;
}

// Delete dNode
Node * deleteNode(Node * node){
    if(node == NULL)
        return NULL;
    Node * temp = node -> next;
    if(temp)
        temp->prev = node->prev;
    free(node->data);
    free(node);
    return temp;
}

// Delete List

/**
 * @brief  Delete Entire List
 * @param  *head: head of list
 * @param  type: type of list (might not be necessary)
 * @retval None
*/
void deleteSList(sNode *head, int type){ 
    while(head){
        head = deleteSNode(head);
    } 
}

void deleteList(Node *head){
    while(head){
        head = deleteNode(head);
    } 
}

int *MakeInt(int value)
{
    int * ptr = malloc(sizeof(int));
    *ptr = value;
    return ptr;
}



// print List

void PrintList(Node *head, void (*func)(Node*)){
    while(head){
        func(head);
        head = head->next;
    }
}

// Merge Sort List 

// Create List from array?