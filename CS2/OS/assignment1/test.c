#include "dispatcher.h"

int main(int argc, char const *argv[])
{
    int a[4] = {1,2,3,4},b[4]={5,6,7,8};
    Process *head; // EQUIVALENT to APPEND(1,2,3,4,NULL);
    head = first_Node(head,a);
    appendProcess(head, b);
    traverse(head, 1);
    return (0);
}
