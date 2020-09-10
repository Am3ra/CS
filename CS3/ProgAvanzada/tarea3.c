#include <stdio.h>
#include <inttypes.h>
#include <stdlib.h>
int32_t four_bytes_from_input()
{
    uint8_t a=0;
    int32_t b = 0;

    for (int i = 0; i < 4; i++)
    {
        b=b<<8;
        printf("STARTING: %8x\n",b);
        scanf("%"SCNx8,&a);
        b|=a;
        printf("%8x\n",b);
    }
    
    return b;
}

int32_t four_bytes(uint8_t a, uint8_t b, uint8_t c, uint8_t d)
{

    int32_t result = 0;

    result|= (int32_t)((a<<24)|(b<<16)|(c<<8)|d);
    

    return result;
}

int digits_in_binary(int a)
{
    int sum = 0;
    while (a)
    {
        if (a & 1)
            sum++;
        a = a >> 1;
    }
    return sum;
}

int compare_two(int a, int b)
{
    int result_a = digits_in_binary(a);
    int result_b = digits_in_binary(b);

    if (a > b)
        return 1;
    else if (a == b)
        return 0;
    else
        return -1;
}

uint8_t rotate(uint8_t c, int bits)
{
    if (bits > 0)
    {
        for (int i = 0; i < bits; i++)
        {
            c = ((c&1)<<7)|(c>>1);
        }
        return c;
    }
    else if (bits < 0)
    {
        for (int i = 0; i < abs(bits); i++)
        {
            c = (c&8)|(c<<1);
        }
        return c;
    }
    else
        return c;
}

int main(int argc, char const *argv[])
{
    printf("%d\n",rotate(0x1,-1));
    printf("%x\n",four_bytes(0xff,0xaa,0xbb,0xcc));
    return 0;
}
