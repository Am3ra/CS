#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct empleado {
    char nombre[30];
    int salario;
    int edad;
    int credito;
    struct empleado *next;
}Empleado;

void imprimirEmpleados(){
    FILE *fp = fopen("salaries.csv","r");
    char buffer[100],c;//Saltar la primera linea
    fgets(buffer, 100, fp);
    
    if (fp == NULL) 
    { 
        printf("Cannot open file \n"); 
        exit(0); 
    } 
    c = fgetc(fp); 
    while (c != EOF) 
    { 
        printf ("%c", c); 
        c = fgetc(fp); 
    } 
  
    fclose(fp); 
}

void agregarEmpleado(){
    Empleado emp;
    printf("Nombre: ");
    scanf("%s",emp.nombre);
    printf("Salario: ");
    scanf("%d",&emp.salario);
    printf("Edad: ");
    scanf("%d",&emp.edad);
    printf("Credito: ");
    scanf("%d",&emp.credito);
    FILE *fp = fopen("salaries.csv","a");
    if (fp == NULL) 
    { 
        printf("Cannot open file \n"); 
        exit(0); 
    } 

    fprintf(fp,"%s,%d,%d,%d\n",emp.nombre,emp.salario,emp.edad,emp.credito);

}

float DistanciaEuclideana(float x1,float x2,float y1, float y2){
    return sqrtf(powf(x1+x2,2)+powf(y1+y2,2));
}

int MasParecido(Empleado *head,Empleado *comp){
    float minDistance = 99999;
    int credito = 0;
    while (head!=NULL)
    {
        float dist = DistanciaEuclideana(head->edad,comp->edad,head->credito,comp->credito);
        if (dist < minDistance)
        {
            minDistance = dist;
            credito = head->credito;
        }
        

        head = head->next;
    }
    return credito;
}

void predecirCredito() {
    Empleado comp;
    printf("Escriba el nombre del empleado: ");
    scanf("%s",comp.nombre);

    FILE *fp = fopen("salaries.csv","r");
    char buffer[100],c;//Saltar la primera linea
    fgets(buffer, 100, fp);


    if (fp == NULL) 
    { 
        printf("Cannot open file \n"); 
        exit(0);     
    }
    Empleado emp; 

    while(fgets(buffer,100,fp)!= NULL) /* read a line from a file */ {
      fprintf(stdout,"%s",buffer); //print the file contents on stdout.
    }

    fclose(fp); 
}


int main(int argc, char const *argv[])
{
    while (1)
    {
        int option=4;
        printf("ESCOGA UNA OPCION:\n");
        printf("1)Mostrar datos\n");
        printf("2)Agregar empleado nuevo\n");
        printf("3)Predecir el credito para empleado nuevo\n");
        printf("4)salir\n");

        scanf("%d",&option);
        switch (option)
        {
            case 1:
                imprimirEmpleados();
                continue;
            case 2:
                agregarEmpleado();
                continue;
            case 3:
                predecirCredito();
                continue;
            case 4:
                exit(0);
            default:
                continue;
        }
    /* code */
    return 0;
    }
    
    
}
