#include <stdio.h>
#include <stdlib.h>
typedef struct process //Create linked list structure
{
    int data[4];
    struct process *next;
}Process;


/*
CREATE STRUCT OF PROCESS TYPE. MIGHT CONSIER CHANGING ALL THE ARGUMENTS INTO SINGLE
ARRAY FOR SAKE OF SIMPLICITY, ALTHOUGH MORE EXPLICIT NOW
*/
Process *create(int data[4], Process *next){
    Process *new_process = (Process*)malloc(sizeof(Process));
    if (new_process == NULL){
        printf("ERROR NEW PROCESS");
        exit(-1);
    }
    new_process -> next = next;
    new_process -> data[0] = data[0];
    new_process -> data[1] = data[1];
    new_process -> data[2] = data[2];
    new_process -> data[3] = data[3];
    return new_process;
}

typedef void (*callback) (Process* data); // EXAMPLE OF POINTER TO FUNCTION AS CALLBACK TO BE USED

void traverse(Process *head,int index){
    printf("TRAVERSE INITIATED\n");
    Process *cursor = head;
    while(cursor != NULL){
        printf("index %d: %d\n", index,cursor ->data[index]);
        cursor = cursor -> next;
    }
    
}
Process* first_Node(Process *head, int data[4]){
    head = create(data, head);
    return head;
}

void appendProcess(Process *head, int data[4]){
    Process *cursor = head;
        while (cursor->next != NULL)
            cursor = cursor->next;
        cursor-> next = create(data, NULL);
    
}
// struct process* create(int pid, int arrival_time, int cpu_burst, int priority, struct process* next)
// {
//     struct process* new_process = (struct process*)malloc(sizeof(struct process));
//     if(new_process == NULL)
//     {
//         printf("Error creating a new process.\n");
//         exit(0);
//     }
//     new_process->pid = pid;
//     new_process->arrival_time = arrival_time;
//     new_process->cpu_burst = cpu_burst;
//     new_process->priority = priority;
//     new_process->next = next;
 
//     return new_process;
// }
