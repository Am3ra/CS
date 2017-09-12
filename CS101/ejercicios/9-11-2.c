#include <stdio.h>


 int r,x,y=2,z=0;
 int main() {
   while (x-r < 10){
     x=0;
     y=0;
     while ((x < 1) || (x>1000)){
       printf("Indique valor del limite superior: " );
       scanf("%d",&x);
       if ((x<1)||(x>1000)){
         printf("Error, numero deberá ser entre 1 y mil. \n");
       }
     }
     while ((r < 1) || (r>1000)){
       printf("Indique valor del limite inferior: " );
       scanf("%d",&r);
       if ((r<1)||(r>1000)){
         printf("Error, numero deberá ser entre 1 y mil. \n");
       }
     }
     if (r >= x-10){
       printf("Error. La diferencia entre los limites debe de ser mayor que 10\n");
     }
   }

   while( r <= x){
     while (y < r){
       if (x%y==0)
       z=1;
       y++;
     }
     if (z == 0){
       printf("%d",r);
     }
     r++;
   }




   return 0;
 }
