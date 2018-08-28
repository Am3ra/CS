#include "dispatcher.h"

int main(int argc, char const *argv[])
{
    int a[4] = {10,22,4},b[4]={5,11,7,8},c[4]={9,12,11,12};
    Process *head = NULL;
    head = first_Node(head,a);
    appendProcess(head,b);
    traverse(head);
    Process *head_copy = CopyList(head);
    Process *cursor = head_copy;
    
    while(cursor != NULL){
        
        if (cursor->data[PID]==10) {
            insertNodeAfter(cursor,c);
            break;
        }
        
        cursor = cursor ->next;
    }
    
    traverse(head_copy);

    head_copy = CopySortedList(head_copy,2);
    printf("FINAL\n\n\n");
    traverse(head_copy);

    return (0);
}
