#include <stdio.h>
struct process //Create linked list structure
{
    int pid, arrival_time, cpu_burst, priority, wait_time,response_time;
    struct process *next;
};

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

void printStuff(){
    printf("%lu\n",sizeof(struct process));
}