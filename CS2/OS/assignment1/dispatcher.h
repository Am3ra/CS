#include <stdio.h> //printf
#include <stdlib.h>
#include <stdbool.h> //Used for boolean values

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
    Function to Create another node for the list.

    INPUT: 
        int array size 4, which should be structured (PID,ARRIVAL_TIME,CPU_BURST,PRIORITY)
        Pointer to next node. If NULL, created node is end of linked list.

    OUTPUT:
        pointer to created node.
*/
Process *Create(int data[4], Process *next)
{
    Process *new_process = (Process *)calloc(1, sizeof(Process)); //changed from malloc. Proud of finding this error!
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
int Traverse(Process *head)
{
#ifdef DEBUG

    printf("TRAVERSE INITIATED\n");
#endif //DEBUG
    Process *cursor = head;
    int c = 0;

    if (head == NULL)
    {
        printf("NULL HEAD\n");
        return 0;
    }
    else
    {

        while (cursor != NULL)
        {
#ifdef DEBUG

            printf("index %d: (PID,%d), (ARRIVAL_TIME,%d), (CPU_BURST,%d),(PRIORITY,%d),(WAIT,%d),(RESPONSE,%d)\n",
                   c,
                   cursor->data[PID],
                   cursor->data[ARRIVAL_TIME],
                   cursor->data[CPU_BURST],
                   cursor->data[PRIORITY],
                   cursor->wait,
                   cursor->response);
#endif //DEBUG
            cursor = cursor->next;
            c++;
        }
        return c;
    }
}

/*
    Function to print vital statistics from process.

    Input:
        String of name of function

    output:
        To terminal,
            #processes processed
            Avg. Wait time
            Avg. Response time. 
*/
void PrintResults(char message[], Process *head)
{
    printf("\n%s\n", message);
    Traverse(head);
    Process *cursor = head;
    int wait = 0, count = 0, response = 0;
    if (head == NULL)
    {
        printf("NULL HEAD PRINT RESULTS FUNCTION\n");
    }
    else
    {
        while (cursor != NULL)
        {
            wait += cursor->wait;
            response += cursor->response - 1;
            count++;
            cursor = cursor->next;
        }
        printf("FOR: %2d PROCESSES\n", count);
        printf("AVG. WAIT   :%2.2f\n", ((float)wait / (float)(count)));
        printf("AVG RESPONSE:%2.2f\n\n\n", (float)response / (float)(count));
    }
}

/* 
    Function to dispose of linked list memory

    INPUT: 
        head of linked list.
*/
void DestroyList(Process *head)
{

    Process *cursor = head,
            *temp;

    while (cursor != NULL)
    {
        temp = cursor->next;
        free(cursor);
        cursor = temp;
    }
}

/**
    Function to insert node at beginning of List.
    Functionally similar to the Create function.

    usage example:

    head = FirstNode(head,data);
*/
Process *FirstNode(Process *head, int data[4])
{
    return Create(data, head);
}

/*
    Function to Create node with data, at the end of 
    the Linked List.

    INPUT:
        pointer to head.
        data array of size 4.
*/
void AppendProcess(Process *head, int data[4])
{
    Process *cursor = head;
    while (cursor->next != NULL)
        cursor = cursor->next;
    cursor->next = Create(data, NULL);
}

/*
    Function that inserts linked list node after specified node.

    INPUT:
        pointer of previous node
        data of node to be created.

*/
void InsertNodeAfter(Process *node, int data[4])
{
    Process *next = node->next;
    node->next = Create(data, next);
}

/*
    Function to swap two nodes for purpose of sorting

    INPUT:
        First node, to be swapped with its own next node.

    OUTPUT:
        Pointer to new first node.
*/
Process *SwapNodes(Process *node)
{
    //Explicitly do everything for certainty.
    Process *newFirst = node->next;
    Process *newSecond = node->next->next;
    newFirst->next = node;
    node->next = newSecond;
    return newFirst;
}

/**
 * @brief  Function to print a single node.
 * @note   Might use to simplify other functions.
 * @param  *node: 
 * @retval None
 */
void PrintNode(Process *node)
{
    printf("{(PID,%d), (ARRIVAL_TIME,%d), (CPU_BURST,%d),(PRIORITY,%d),(WAIT,%d),(RESPONSE,%d)}\n",
           node->data[PID],
           node->data[ARRIVAL_TIME],
           node->data[CPU_BURST],
           node->data[PRIORITY],
           node->wait,
           node->response);
}

/**
 * Function to sort Linked List in place.
 * Since already did a strange implementation of insertion sort,
 * it was time to do a strange implementarion of bubble sort.
 * @param  *head: head of Linked List.
 * @retval None
 * @see CopySortedList()
 */
Process *SortList(Process *head, int TYPE)
{
    Process *cursor = head;
    Process *a;
    Process *b;
    bool sorted = false;

    if (head == NULL)
        return NULL;

    while (!sorted)
    {
        cursor = head;
        a = cursor->next;
        b = cursor->next->next;
        sorted = true; //Assume sorted until proved otherwise.
        if (cursor == head)
        {
            if ((cursor->data[TYPE] > cursor->next->data[TYPE]))
            { //Compare elements, and swap if first larger than second
                sorted = false;
                head = SwapNodes(head);
                cursor = head;
                a = cursor->next;
                b = cursor->next->next;
            }
            else if (cursor->data[TYPE] == cursor->next->data[TYPE])
            { //if equal, check PID then swap if necessary.
                if (cursor->data[PID] > cursor->next->data[PID])
                {
                    sorted = false;
                    head = SwapNodes(head);
                    cursor = head;
                    a = cursor->next;
                    b = cursor->next->next;
                }
            }
        }

        while (cursor->next != NULL && cursor->next != NULL && cursor->next->next != NULL)
        { //I've put the first statement in order to avoid cases where there are fewer than three nodes. Avoid segfaults

            Process *a = cursor->next;
            Process *b = cursor->next->next;

            if ((a->data[TYPE] > b->data[TYPE]) ||
                (a->data[TYPE] == b->data[TYPE] && a->data[PID] > b->data[PID]))
            {
                sorted = false;
                cursor->next = SwapNodes(a);
            }

            cursor = cursor->next;
        }
    }
    return head;
}

/*
    Function to Return the head of a copy of linked list

    INPUT:
        Head pointer of linked list 

    Output:
        Copied Linked list head.
*/
Process *CopyList(Process *head)
{
    Process *copy_head = NULL;
    Process *cursor = head;
    int count = 0;
    while (cursor != NULL)
    {
        int data[4];
        data[PID] = cursor->data[PID];
        data[ARRIVAL_TIME] = cursor->data[ARRIVAL_TIME];
        data[CPU_BURST] = cursor->data[CPU_BURST];
        data[PRIORITY] = cursor->data[PRIORITY];
        cursor = cursor->next;
        if (head == NULL)
        {
            return NULL;
        }
        else if (count == 0)
        {
            count++; // Make sure never enters this if again.
            copy_head = FirstNode(copy_head, data);
        }
        else
        {
            AppendProcess(copy_head, data);
        }
    }
    return copy_head;
}

/*
    Function to simulate First Come First Served scheduling policy.

    INPUT:
        Head pointer of linked list
    NOTE:
        Finished coding. 
        Pending tests.
*/
void FirstCome(Process *head_original)
{
    Process *head = SortList(CopyList(head_original), ARRIVAL_TIME); // New list sorted by ARRIVAL TIME
    Process *cursor = head;
    int cycle_counter = 0;

    if (head == NULL)
    {
        printf("NULL HEAD, FCFS\n");
    }
    else
    {
        while (cursor != NULL)
        {
            while (cycle_counter < cursor->data[ARRIVAL_TIME]) //This is useful in event of gaps
            {
                cycle_counter++;
            }

            cursor->wait = cycle_counter - cursor->data[ARRIVAL_TIME];
            cursor->response = cycle_counter + 1;
            cycle_counter += cursor->data[CPU_BURST]; //assumes that the process finishes.
            cursor = cursor->next;
        }

        PrintResults("FIRST COME FIRST SERVED RESULTS:", head);
    }
    DestroyList(head);
}

/*
    Function to simulate non pre-emptive scheduling policies.

    INPUT:
        Head pointer of linked list
        Type of non-preemptive policy, list to be ordered by it.
*/
void NonPreemptive(Process *head, int TYPE)
{
    Process *copy_head = SortList(CopyList(head), TYPE);
    Process *cursor;
    int cycle = 0;
    bool complete = false;  //Check if all processes finished
    bool processed = false; //Check if at least 1 process processed

    if (head == NULL)
    {
        printf("NULL HEAD: NON PREEMPTIVE FUNCTION\n");
    }
    else
    {
        while (!complete)
        {
            complete = true;   //Assume complete until proven otherwise.
            processed = false; //Assume none processed.
            copy_head = SortList(copy_head, TYPE);
            cursor = copy_head;
            while (cursor != NULL)
            {
                if (cursor->data[CPU_BURST]) //Check if not complete
                {
                    complete = false;
                    if (cursor->data[ARRIVAL_TIME] <= cycle) //check if already arrived
                    {
                        if (!processed) //check if no other process processed.
                        {
                            processed = true;
                            cursor->response = cycle + 1; //+1 is there to make sure none is 0
                            cursor->wait = cycle - cursor->data[ARRIVAL_TIME];
                            cycle += cursor->data[CPU_BURST]; //Assume process is completed
                            cursor->data[CPU_BURST] = 0;
                        }
                    }
                }

                cursor = cursor->next;
            }
            if (!complete && !processed) //check for gaps.
            {
                cycle++;
            }
        }
    }

    switch (TYPE)
    {
    case ARRIVAL_TIME:
        PrintResults("NON-PREEMPTIVE SORTED ARRIVAL TIME RESULTS:", copy_head);
        break;
    case CPU_BURST:
        PrintResults("NON-PREEMPTIVE SHORTEST JOB FIRST RESULTS:", copy_head);
        break;
    case PRIORITY:
        PrintResults("NON-PREEMPTIVE PRIORITY SORTED RESULTS:", copy_head);
        break;
    case PID:
        PrintResults("NON-PREEMPTIVE PID SORT RESULTS:", copy_head);
        break;

    default:
        break;
    }

    DestroyList(copy_head);
}

/*
    Function to simulate pre-emptive scheduling policies.

    INPUT:
        Head pointer of linked list 
        Type of preemptive policy, list to be ordered by it.
*/
void Preemptive(Process *head, int TYPE)
{
    Process *copy_head = SortList(CopyList(head), TYPE);
    Process *cursor;
    int cycle = 0;
    bool complete = false,
         processed = false;

    if (head == NULL)
    {
        printf("NULL HEAD, PREEMPTIVE FUNCTION\n");
    }
    else
    {

        while (!complete)
        {
            complete = true; //assume complete until told otherwise
            processed = false;
            copy_head = SortList(copy_head, TYPE);
            cursor = copy_head;
            // printf("CYCLE: %2d\n",cycle);
            while (cursor != NULL)
            {
                // PrintNode(cursor);
                if (cursor->data[CPU_BURST])
                { //check if not complete
                    complete = false;
                    if (cursor->data[ARRIVAL_TIME] <= cycle) //check if arrived
                    {
                        if (!processed)
                        {
                            processed = true;
                            if (!cursor->response)
                                cursor->response = cycle + 1;
                            cycle++;
                            cursor->data[CPU_BURST]--; // only removes 1 cycle.
                        }
                        else if (cursor->data[ARRIVAL_TIME] < cycle)
                        {
                            cursor->wait++; //add wait time to waiting processes.
                        }
                    }
                }

                cursor = cursor->next;
            }

            if (!complete && !processed)
            {
                cycle++;
            }
        }

        switch (TYPE)
        {
        case ARRIVAL_TIME:
            PrintResults("PREEMPTIVE SORTED BY  ARRIVAL TIME RESULTS:", copy_head);
            break;
        case CPU_BURST:
            PrintResults("PREEMPTIVE SHORTEST JOB FIRST RESULTS:", copy_head);
            break;
        case PRIORITY:
            PrintResults("PREEMPTIVE PRIORITY SORTED RESULTS:", copy_head);
            break;
        case PID:
            PrintResults("PREEMPTIVE PID SORT RESULTS:", copy_head); //should not be necessary, but there in case.
            break;

        default:
            break;
        }
    }

    DestroyList(copy_head);
}

/*
    Function to simulate Round Robin scheduling policy.

    INPUT:
        Head pointer of linked list 
        Quantum.
*/
void RoundRobin(Process *head, int quantum)
{
    Process *copy_head = SortList(CopyList(head), ARRIVAL_TIME);
    Process *cursor;
    int cycle = 0,
        temp_counter = 0;
    bool complete = false,
         processed = false;

    if (copy_head == NULL)
    {
        printf("NULL HEAD ROUND ROBIN\n");
    }
    else
    {
        while (!complete)
        {

            complete = true;
            processed = false;
            copy_head = SortList(copy_head, ARRIVAL_TIME);
            cursor = copy_head;
            while (cursor != NULL)
            {
                if (cursor->data[CPU_BURST])
                { //check if completed.
                    complete = false;
                    if (cursor->data[ARRIVAL_TIME] <= cycle)
                    {
                        if (!processed)
                        {
                            processed = true;
                            if (!cursor->response) //check if already processed.
                                cursor->response = cycle + 1;
                            if (cursor->data[CPU_BURST] <= quantum)
                            { //check if process is completed during quantum or not.
                                temp_counter = cursor->data[CPU_BURST];
                                cursor->data[CPU_BURST] = 0;
                            }
                            else
                            {
                                cursor->data[CPU_BURST] -= quantum;
                                temp_counter = quantum;
                            }
                            cycle += temp_counter;
                            cursor->data[ARRIVAL_TIME] = cycle + 1; //change arrival time for sorting purposes.
                        }
                        else
                        {
                            if (!cursor->response) //check if already processed.
                                cursor->wait = (cycle - cursor->wait) - cursor->data[ARRIVAL_TIME];
                            else
                                cursor->wait += temp_counter; //if processed add necessary time
                        }
                    }
                    else if (cursor->response)
                    //Because arrival time can't be trusted, check response time,
                    //since if processed will be different to 0.
                    {
                        cursor->wait += temp_counter;
                    }
                }
                cursor = cursor->next;
            }

            if (!complete && !processed)
            { //check for gaps.
                cycle++;
            }
        }

        PrintResults("ROUND ROBIN RESULTS:", copy_head);
    }
    DestroyList(copy_head);
}
