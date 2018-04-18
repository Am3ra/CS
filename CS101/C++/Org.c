#include <stdio.h>
#include <ctype.h>
#include <stdbool.h> 

#define CACHESIZE 16

struct cache{
    unsigned int address;
    char         state;
};
struct cacheFA{
    unsigned int address;
    unsigned int time;
    char         state;
};

unsigned int events = 0;

struct cache myCache[CACHESIZE];
struct cacheFA myCacheFA[CACHESIZE];

enum values { VALID, INVALID, EMPTY };

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
unsigned int GetAddr (FILE *fp)
{
    char	             c;	   	                    /* Character read */
    unsigned int         address;
    
    do {
        c = getc (fp);	                        /* Get next character */
        if ( c == '#' )	                          /* Skip the comment */
            do {
                c = getc (fp);
            } while ( c != '\n');
    } while (!isxdigit(c) && !feof(fp));
    
    ungetc(c, fp);                /* Return the character to the file */
    fscanf(fp, "%x\n",&address);
            
    return (address);
}

/**********************************************************************/
/*                                                                    */
/* Name: CacheAccess                                                   */
/*                                                                    */
/* Description: This function will simulate a direct mapped cache     */
/*                                                                    */
/* Inputs:      An address in hexadecimal format                      */
/*                                                                    */
/* Outputs:     The hit rate (p)                                      */
/*                                                                    */
/**********************************************************************/
int CacheAccess (unsigned int address){
    
    static unsigned int hit = 0;
    int end = address & 0x000f;
    
    if(myCache[end].state==VALID && myCache[end].address == address)
    {
        hit++;
    }else
    {
        myCache[end].state=VALID;
        myCache[end].address=address;
    }
    
    
    return hit;
}
/**********************************************************************/
/*                                                                    */
/* Name: CacheAccessFA                                                */
/*                                                                    */
/* Description: This function will simulate a fully associative cache */
/*                                                                    */
/* Inputs:      An address in hexadecimal format                      */
/*                                                                    */
/* Outputs:     The hit rate (p)                                      */
/*                                                                    */
/**********************************************************************/
int CacheAccessFA (unsigned int address){
    
    static unsigned int hit = 0;
    unsigned int minTime=99999;
    bool found=false;
    
    for(int i = 0;i < CACHESIZE;i++)
    {
        if (myCacheFA[i].time <minTime)
        {
            minTime = myCacheFA[i].time;
        }
        if (myCacheFA[i].state==VALID && myCacheFA[i].address == address)
        {
            hit++;
            found = true;
            myCacheFA[i].time= events+1;
            break;
        }
    }

    if (!found)
    {
        for(int i = 0;i < CACHESIZE;i++)
        {
            if (myCacheFA[i].time == minTime){
                
                myCacheFA[i].state = VALID;
                myCacheFA[i].address = address;
                myCacheFA[i].time = events+1;
                break;
            }
        }
    }
    
    return hit;
}

int main (int argc, const char * argv[]) {
    
    FILE         *fp;                    /* Pointer to the input file */
    unsigned int ref,hitsDM,hitsFA;
    
    /* Initialize the cache */
    for (int i=0; i < CACHESIZE; i++){
        myCache[i].state = INVALID;
        myCache[i].address = EMPTY;
        myCacheFA[i].state = INVALID;
        myCacheFA[i].address = EMPTY;
        myCacheFA[i].time = 0;
    }
    
    fp = fopen ("trace.txt","r");		 /* Open file for read operation */

    while (!feof(fp)) {
        ref = GetAddr(fp);
        hitsDM = CacheAccess(ref);
        hitsFA = CacheAccessFA(ref);
        events++;
    }
    /* Print the hit rate of the cache */
    printf("Percentage hits Direct Mapped     : %2.2f%% (%d/%d)\n",hitsDM/(float)events*100,hitsDM,events);
    printf("Percentage hits Fully Associative : %2.2f%% (%d/%d)\n",hitsFA/(float)events*100,hitsFA,events);

    return 0;
}