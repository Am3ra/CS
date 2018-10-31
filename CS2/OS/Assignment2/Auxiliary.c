#include "Auxiliary.h"
#include "VirtualMemory.h"
#include <stdio.h>



void PrintData(){
    extern struct reference address;
    printf("%d, %c\n",address.address,address.access);
}