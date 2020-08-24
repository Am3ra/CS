#include <stdio.h>
#define clear() printf("\033[H\033[J")
#define gotoxy(x,y) printf("\033[%d;%dH", (x), (y))

int main() {
  char password[25], ch;
   int i;

   clear();
   puts("Enter password : ");

   while (1) {
      if (i < 0) {
         i = 0;
      }
      ch = getch();

      if (ch == 13)
         break;
      if (ch == 8) /*ASCII value of BACKSPACE*/
      {
         printf("b");
         printf(NULL);
         printf("b");
         i--;
         continue;
      }

      password[i++] = ch;
      ch = '*';
      putch(ch);
   }

   password[i] = '\0';
   printf("\nPassword Entered : %s", password);

   getch();
  return 0;
}
