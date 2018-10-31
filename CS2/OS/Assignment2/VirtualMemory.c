
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
#include "FileIO.h"
#include "Auxiliary.h"
#include "VirtualMemory.h"

#define TLB_SIZE 8
#define VIRTUAL_MEM_SIZE 16
#define OFFSET 9
#define PHYSICAL_MEM_SIZE 13
#define PAGE_TABLE 128
#define EXPECTED_ARGS 2

struct reference address;

struct MMUstruct[TLB_SIZE] TLB;

int main(int argc, char const *argv[])
{
    FILE *fp;
    unsigned int Tmem, Ttlb, Tfault;
    
    fp = fopen("testTrace.txt", "r"); //Name of trace file

    if (fp == NULL) //Check if open worked correctly;
    {
        printf("ERROR OPENING FILE\n");
        exit(EXIT_FAILURE);
    }
    else //file is open.
    {
        Tmem = GetInt(fp);   //Get Initial Values.
        Ttlb = GetInt(fp);   //
        Tfault = GetInt(fp); //

        printf("Tmem: %d, Ttlb: %d, Tfault: %d\n", Tmem, Ttlb, Tfault);

        while ((address.address = GetAddr(fp)) && (address.access = GetType(fp)) && !feof(fp)) // Loop through all addresses and access types, and check address and access type != 0;
        {

            printf("%x ", address.address);
            printf("%c\n", address.access);
        }
    }

    return 0;
}
