
typedef struct complex_number
{
    int integer;
    int i;
} complex;

complex * Negation(complex * number){
    number->i = -number->i;
    number->integer = -number->integer;
    return number;
}

complex * Addition (complex * a, complex *b){
    
}