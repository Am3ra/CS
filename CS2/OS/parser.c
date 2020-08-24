#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    FILE *fp;
    char letter;

        if (argc != 2)
    {
        printf("Correct Usage: parser filename\n");
        exit(EXIT_FAILURE);
    }else
    {
        fp = fopen(argv[1], "r");
        printf("%s\n",argv[1]);
        if (fp==NULL)
        {
            printf("ERROR LOADING FILE\n");
            exit(EXIT_FAILURE);
        }
        int j = 100;
        while(!feof(fp)){
            letter = getc(fp);
        }
        
    }
    
    fclose(fp);
    return 0;
}
