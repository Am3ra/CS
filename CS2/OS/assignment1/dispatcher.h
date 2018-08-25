#include <stdio.h>
#include <stdlib.h>

/*
    CREATE STRUCT OF PROCESS TYPE. CHANGED STRUCT TYPE SO THAT 
    DATA IS SIMPLE ARRAY FOR SAKE OF PASSING ARGUMENTS FOR
    SORTING, WHILE WAIT AND RESPONSE REMAIN SIMPLE INTS.

    TODO: Consider generalizing functions into lib, by generalizing
    the struct into only having two "attributes", data - a void pointer -, 
    and next as is.
*/
typedef struct process //Create linked list structure
{
    int data[4];
    int wait;
    int response;
    struct process *next;
} Process; //Found it was necessary, don't know why, hahaha.

/*
    Enum in order to access array values more easily.
*/
enum attributes
{
    PID,
    ARRIVAL_TIME,
    CPU_BURST,
    PRIORITY
};

/*
    Function to create another node for the list.

    INPUT: 
        int array size 4, which should be structured (PID,ARRIVAL_TIME,CPU_BURST,PRIORITY)
        Pointer to next node. If NULL, created node is end of linked list.

    OUTPUT:
        pointer to created node.
*/
Process *create(int data[4], Process *next){
    Process *new_process = (Process *)malloc(sizeof(Process));
    if (new_process == NULL)
    {
        printf("ERROR NEW PROCESS");
        exit(-1);
    }
    new_process->next = next;
    new_process->data[PID] = data[PID];
    new_process->data[ARRIVAL_TIME] = data[ARRIVAL_TIME];
    new_process->data[CPU_BURST] = data[CPU_BURST];
    new_process->data[PRIORITY] = data[PRIORITY];
    return new_process;
}

/* 
    Function has double purpose, may be split in two later.
    1. Print complete data structure to terminal.
    2. Count number of nodes in the structure.

    INPUT: 
        Pointer to head of list.

    OUTPUT:
        int of final count.

    NOTES:  for debugging purposes, it is possible to call
            the function without assigning the returned
            value to anything.
*/
int traverse(Process *head){
    printf("TRAVERSE INITIATED\n");
    Process *cursor = head;
    int c = 0;
    while (cursor != NULL)
    {
        printf("index %d: (PID,%d), (ARRIVAL_TIME,%d), (CPU_BURST,%d),(PRIORITY,%d)\n", 
                        c, 
                        cursor->data[PID], 
                        cursor->data[ARRIVAL_TIME], 
                        cursor->data[CPU_BURST], 
                        cursor->data[PRIORITY]);
        cursor = cursor->next;
        c++;
    }
    return c;
}

/*
    Function to insert node at beginning of List.
    Functionally similar to the create function.
*/
Process *first_Node(Process *head, int data[4]){
    head = create(data, head);
    return head;
}

/*
    Function to create node with data, at the end of 
    the Linked List.

    INPUT:
        pointer to head.
        data array of size 4.
*/
void appendProcess(Process *head, int data[4]){
    Process *cursor = head;
    while (cursor->next != NULL)
        cursor = cursor->next;
    cursor->next = create(data, NULL);
}

/*
    Function that inserts linked list node after specified node.

    INPUT:
        pointer of previous node
        data of node to be created.

*/
void insertProcessAfter(Process *node, int data[4]){

}

/*
    Function to Return the head of a copy of linked list

    INPUT:
        Head pointer of linked list 

    Output:
        Copied Linked list head.
*/
Process* CopyList(Process *head){
    Process *copy_head = NULL;
    Process *cursor = head;
    int count = 0;
    while(cursor!= NULL){
        int data[4] = {cursor -> data};
        cursor = cursor ->next;
        if (head == NULL) {
            return NULL;
        }
        else if(count == 0){
            count ++; // Make sure never enters this if again.
            copy_head = first_Node(copy_head,data);
        } 
        else{
            appendProcess(copy_head,data);
        }   
    }
    return copy_head;
}

/*
    Function to sort given linked list.

    INPUT:
        head pointer of list
        function pointer, in order to psas arbitrary parameters.
*/
void SortList(Process *head, void (*sort)()){
    printf("SORT LINKED LIST\n");
}

/*
    Function to simulate First Come First Served scheduling policy.

    INPUT:
        Head pointer of linked list

    TODO: 
        Make copy of linked list in order to be able to modify it 
        without risk of affecting other processes.
*/
void FirstCome(Process *head){
    printf("(FCFS)SORT BY ARRIVAL_TIME, THEN PROCESS\n");
}

/*
    Function to simulate non pre-emptive scheduling policies.

    INPUT:
        Head pointer of linked list
        Type of non-preemptive policy, list to be ordered by it.

    TODO: 
        Make copy of linked list in order to be able to modify it 
        without risk of affecting other processes.
*/
void NonPreemptive(Process *head, int TYPE){
    printf("(NP)SORT BY TYPE THEN PROCESS\n");
}

/*
    Function to simulate pre-emptive scheduling policies.

    INPUT:
        Head pointer of linked list 
        Type of preemptive policy, list to be ordered by it.


    TODO: 
        Make copy of linked list in order to be able to modify it 
        without risk of affecting other processes.
*/
void Preemptive(Process *head, int TYPE){
    printf("(P)SORT BY TYPE THEN PROCESS, sorting constantly\n");
}
/*
    Function to simulate Round Robin scheduling policy.

    INPUT:
        Head pointer of linked list 
        Quantum.


    TODO: 
        Make copy of linked list in order to be able to modify it 
        without risk of affecting other processes.
*/

void RoundRobin(Process *head, int quantum){
    printf("ROUND ROBIN PROCESS\n");
}