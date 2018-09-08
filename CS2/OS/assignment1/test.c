#include "dispatcher.h"

//Archivo de pruebas mias, si lo quieren modificar adelante

int main(int argc, char const *argv[])
{
    int a[4] = {10,22,22,20},b[4]={5,11,7,8},c[4]={9,11,6,12};
    Process *head = NULL;
    head = FirstNode(head,a);
    AppendProcess(head,b);
    Traverse(head);
    Process *head_copy = CopyList(head);
    Process *cursor = head_copy;
    
    while(cursor != NULL){
        
        if (cursor->data[PID]==10) {
            InsertNodeAfter(cursor,c);
            break;
        }
        
        cursor = cursor ->next;
    }
    
    Traverse(head_copy);
    #ifdef DEBUG
        printf("Cool stuff\n");
    #endif //DEBUG

    head_copy = SortList(head_copy,ARRIVAL_TIME);
    printf("FINAL\n\n\n");
    Traverse(head_copy);

    return (0);
}
