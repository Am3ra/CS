#include <stdio.h>
#include <stdlib.h>
//DONE

int main(int argc, char const *argv[])
{
    int c = -1;
    int steps = 0;
    while(c<=1){
        printf("Input the number greater than 1\n");
        scanf("%d",&c);

        if (c<=1) {
            printf("Number smaller or equal to 1\n");
            continue;
        }
        while(c!=1){
            if(c%2==0){
                c/=2;
            }else{
                c*=3;
                c++;
            }
            steps++;
        }
        break;
    }
    
    printf("Number of steps: %d\n",steps);
    
    return 0;
}
