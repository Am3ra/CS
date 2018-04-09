#include <stdio.h>
#include <ctype.h>

#define CACHESIZE 16

struct cache{
   unsigned int address;
   char         state;
};

unsigned int events = 0;

struct cache myCache[CACHESIZE];
enum values { VALID = 0, INVALID, EMPTY };

/**********************************************************************/
/*                                                                    */
/* Name: GetAddr                                                      */
/*                                                                    */
/* Description: This function will read the input file and returns an */
/*              hexadecimal number. It will skip over comments, which */
/*              begin the line with a  #                              */
/*                                                                    */
/* Inputs:      The name of the input file                            */
/*                                                                    */
/* Outputs:     The address that will be presented to the cache       */
/*                                                                    */
/**********************************************************************/
unsigned int GetAddr (FILE *fp){
  char                     c; /* Character read */
  unsigned int         address;

  do {        
      c = getc (fp);                            /* Get next character */
      if ( c == '#' )                             /* Skip the comment */
          do {                
             c = getc (fp);            
          } while ( c != '\n');
    } while (!isxdigit(c) && !feof(fp));        

  ungetc(c, fp);                  /* Return the character to the file */
  fscanf(fp, "%x\n",&address);

  return (address);
}

/**********************************************************************/
/*                                                                    */
/* Name: CacheAccess                                                  */
/*                                                                    */
/* Description: This function will simulate a direct mapped cache,    */
/*              write a similar function for the fully associative    */
/*              cache.                                                */
/*                                                                    */
/* Inputs:      An address in hexadecimal format                      */
/*                                                                    */
/* Outputs:     The hit rate (p)                                      */
/*                                                                    */
/**********************************************************************/
float CacheAccess (unsigned int adress){
  static unsigned int hit = 0;

        /* Fill in your code here */
   
  return (hit/(float)events);
}

int main (int argc, const char * argv[]) {
    FILE         *fp;                    /* Pointer to the input file */
    unsigned int ref;                         /* Initialize the cache */

   for (int i=0; i < CACHESIZE; i++){
        myCache[i].state = INVALID;
        myCache[i].address = EMPTY;
   }

   fp = fopen ("trace.txt","r");      /* Open file for read operation */

   while (!feof(fp)) {
      ref = GetAddr(fp);
      CacheAccess(ref);               /* Direct mapped cache */

      /* Call the function that implements the fully associative cache here */

      events++;
   }

   /* Print the hit rate of the caches */

}