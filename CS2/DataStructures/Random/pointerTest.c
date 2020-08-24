
#include <stdio.h> 

int main(int argc, char const *argv[])
{
    char a[] = "racecar";
    int length = sizeof(a) / sizeof(a[0]) -1;

    int flag = 0;

    printf("%lu\n",sizeof(a)/sizeof(a[0]));
    printf("Length: %d\n",length);
    for (int i = 0; i < length; i++)
    {
     printf("%c , %c \n",a[i],a[length-i-1]);  
     
        if (a[i] != a[length-i-1]) {
            flag = 1;
            break;
        }
      
    }

    if (flag)
    {
       printf("NOT PALINDROME\n"); 
    }

    return 0;
}
