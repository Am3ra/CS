
#include <stdio.h> /* Used to handle the FILE type */

int main(int argc, char const *argv[])
{
    int x = 1,y=2,*ip;
    ip = &x;
    printf("%d,%d\n",ip,*ip);
    y= *ip;
    printf("%d\n",y);
    *ip = 3;
    printf("%d\n",x);

    return 0;
}
