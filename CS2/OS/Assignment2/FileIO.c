
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
#include <string.h>



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
unsigned int GetAddr(FILE *fp)
{
    char c; /* Character read */
    unsigned int address;

    do
    {
        c = getc(fp); /* Get next character */
        if (c == '#') /* Skip the comment */
            do
            {
                c = getc(fp);
            } while (c != '\n');
    } while (!isxdigit(c) && !feof(fp));

    ungetc(c, fp); /* Return the character to the file */
    fscanf(fp, "%x\n", &address);

    return (address);
}

/*
 *
 *  Function: GetInt
 *
 *  Purpose: The function will read the input file and return an integer
 *           representing the ASCII characters that form a number. It
 *           skips over comments, which begin a line with a #, and other
 *           ASCI characters that do not represent numbers.
 *
 *  Parameters:
 *            input    Pointer to the text file to parse 
 *
 *            output   Integer representing value, only positive values
 *                     are possible. If the end of file is reached a -1
 *                     is returned.
 *
 */
int GetInt(FILE *fp)
{
    int c, i; /* Character read and integer representation of it */
    int sign = 1;

    do
    {
        c = getc(fp); /* Get next character */
        if (c == '#') /* Skip the comment */
            do
            {
                c = getc(fp);
            } while (c != '\n');
        if (c == '-')
            sign = -1;
    } while (!isdigit(c) && !feof(fp));

    if (feof(fp))
    {
        return (EXIT_FAILURE);
    }
    else
    {
        /* Found 1st digit, begin conversion until a non-digit is found */
        i = 0;
        while (isdigit(c) && !feof(fp))
        {
            i = (i * 10) + (c - '0');
            c = getc(fp);
        }

        return (i * sign);
    }
}
/*
 *
 *  Function: GetType
 *
 *  Purpose: The function will read the input file and return an integer
 *           representing the ASCII characters that represent the type of
 *           operation required.
 *
 *  Parameters:
 *            input    Pointer to the text file to parse 
 *
 *            output   Integer representing letter, R or W, only positive values
 *                     are possible. If the end of file is reached a -1
 *                     is returned.
 *
 */
int GetType(FILE *fp)
{
    int c, i; /* Character read and integer representation of it */
    do
    {
        c = getc(fp); /* Get next character */
        if (c == '#') /* Skip the comment */
            do
            {
                c = getc(fp);
            } while (c != '\n');
    } while ( c != 'W' && c!= 'R' && !feof(fp));
    if (feof(fp))
        return (EXIT_FAILURE);
    else
    {
        return c;
    }
}