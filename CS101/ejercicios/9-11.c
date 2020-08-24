#include <stdio.h>


 int x,y=2,z=0;
 int main(int argc, char const *argv[]) {

   while ((x < 1) || (x>1000)){
     printf("Indique valor de X: " );
     scanf("%d",&x);
     if ((x<1)||(x>1000)){
       printf("Error, numero deberá ser entre 1 y mil. \n");
     }
   }
   while (y < x){
     if (x%y==0)
     z=1;
     y++;
   }

   if (z == 1){
     printf("Su número no es primo\n\n\n");
   } else {
     printf("Su número es primo\n\n\n\n");

   }



   return 0;
 }
