#include "dispatcher.h"

int main(int argc, char const *argv[])
{
    int a[4] = {1,2,3,4},b[4]={5,6,7,8},c[4]={9,10,11,12};
    Process *head = NULL;
    head = first_Node(head,a);
    appendProcess(head,b);
    traverse(head);
    Process *head_copy = CopyList(head);
    Process *cursor = head_copy;
    
    while(cursor != NULL){
        
        if (cursor->data[PID]==1) {
            insertNodeAfter(cursor,c);
            break;
        }
        
        cursor = cursor ->next;
    }
    
    traverse(head_copy);
    return (0);
}
