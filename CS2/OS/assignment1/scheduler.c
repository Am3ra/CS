/*
 * Copyright (c) 2012 Abelardo Lopez Lagunas
 * 
 * Program: scheduler.c
 *
 * Author:  Abelardo Lopez Lagunas
 *
 * Purpose: This program impelemnets the basic process scheduling
 *          algorithms for the TC2008 class. 
 *
 * Usage:
 *          The program reads a text file with the processes. The first
 *          integer in the file is the quantum, followed by four integer
 *          numbers per line describing the process id, arrival time, 
 *          cpu burst and priority. The usage form is:
 *
 *          schedule file.txt
 *
 * References:
 *          The material that describe the scheduling algorithms is
 *          covered in my class notes for TC2008
 *
 * File formats:
 *          The input file should have four numbers per list in ASCII
 *          format. The exeption is teh forst line which only has one
 *          integer number that represents the quantum.
 *
 * Restrictions:
 *          If the input file is not in ASCII format the program exits
 *
 * Revision history:
 *
 *          Feb 16 11:57 2011 - File created
 *          
 *          May 24 11:56 2012 - Code refactoring & big fixes
 *
 * Error handling:
 *          On any unrecoverable error, the program exits
 *
 * Notes:
 *          This code presents a solution for the first assignment
 *
 * $Id$
 */

#include <stdlib.h>                     /* Used for malloc definition */
#include <stdio.h>                                /* Used for fprintf */
#include <string.h>                                /* Used for strcmp */
#include <assert.h>                      /* Used for the assert macro */
#include "FileIO.h"    /* Definition of file access support functions */
#include "dispatcher.h"/* Implementation of the dispatcher algorithms */

/***********************************************************************
 *                       Global constant values                        *
 **********************************************************************/
#define NUMPARAMS 2
#define NUMVAL    4

/***********************************************************************
 *                          Main entry point                           *
 **********************************************************************/
int main (int argc, const char * argv[]) {
    
    FILE   *fp;                                /* Pointer to the file */
    int    quantum = 0;              /* Quantum value for round robin */
    // GList  *processList_p = NULL;      /* Pointer to the process list */
    int    parameters[NUMVAL];      /* Process parameters in the line */
    int    i;                  /* Number of parameters in the process */
    Process *head = NULL;              //Start of Process List
    int element_num = 0;                //Counter of processes

    /* Check if the number of parameters is correct */
    if (argc < NUMPARAMS){  
        printf("Need a file with the process information\n");
        printf("Abnormal termination\n");
        return (EXIT_FAILURE);
    } else {
        /* Open the file and check that it exists */
        fp = fopen (argv[1],"r");	  /* Open file for read operation */
        if (!fp) {                               /* There is an error */
            ErrorMsg("main","filename does not exist or is corrupted");
        } else {
            /* The first number in the file is the quantum */
            quantum = GetInt(fp);
            printf("Quantum: %d \n",quantum);
            if (quantum == EXIT_FAILURE) {
                ErrorMsg("main","Quantum not found");
            } else {
                /*
                 * Read the process information until the end of file
                 * is reached.
                 */
                while (!feof(fp)){
                    /* For every four parameters create a new process */
                    for (i = 0; ((i < NUMVAL) && (!feof(fp))); i++) {
                        parameters[i] = GetInt(fp);
                    }
                    
                    /* Do we have four parameters? */
                    if (i == NUMVAL) {
                        if (element_num==0){ //IF FIRST ELEMENT, INITIALIZE HEAD
                            head = FirstNode(head,parameters);
                        }
                        else 
                            AppendProcess(head,parameters); //ELSE APPEND TO END OF LIST
                        element_num++;
                    }
                }
            }
        }
        
        /* Start by sorting the processes by arrival time */
        // processList_p = SortProcessList(processList_p, ARRIVALTIME);
        
        
        /*
         * Apply all the scheduling algorithms and print the results
         */
        FirstCome (head);
        
        NonPreemptive(head, PRIORITY);
        
        NonPreemptive(head, CPU_BURST);
        
        Preemptive(head, PRIORITY);
        
        Preemptive(head, CPU_BURST);
        
        RoundRobin(head, quantum);

        
        DestroyList(head);
        printf("Program terminated correctly\n");
        return (EXIT_SUCCESS);
    }
}