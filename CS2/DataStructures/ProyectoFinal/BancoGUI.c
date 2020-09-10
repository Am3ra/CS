#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

enum resultados
{
    NOT_FOUND,
    FOUND
};

enum tipo
{
    RETIRO,
    DEPOSITO
};

struct transaccion
{
    int nocta;
    enum tipo result;
    int cantidad;
    struct transaccion *next;
} * FirstRetiro, *FirstDeposito;

struct cuenta
{
    int nocta;
    char nombre[80];
    char tipo[80];
    int saldo;
    struct cuenta *next;
} *First = NULL;

void opciones(void), append(struct cuenta *actual), prepend(struct cuenta *actual);
struct cuenta *busquedaCuenta(int nocta), *findLast(void), *capturar(void);
void menuCuenta(struct cuenta *Actual), consultarTxt(char *filename), consultar();
void transaccionCuenta(struct cuenta *Actual, enum tipo tipoTransaccion), initializeLL();
void appendTransaccion(struct transaccion actual), consultarTransaccion(enum tipo tipoActual);
void eliminar(int nocta), saveResults(), cuentaToString(struct cuenta *actual);

int main(int argc, char *argv[])
{
    FILE *fp = fopen("clientes.txt", "r");
    if (fp == NULL)
    {
        printf("FAILURE OPENING TXT\n");
        exit(EXIT_FAILURE);
    }
    fclose(fp);
    initializeLL();
    opciones();
    return EXIT_SUCCESS;
}

void opciones(void)
{

    while (true)
    {

        int option, nocta;
        printf("Bienvenido!\n");
        printf("1)Capturar Datos Nuevos\n");
        printf("2)Add first\n");
        printf("3)Consultar\n");
        printf("4)Consultar No. Cuenta\n");
        printf("5)Consultar TXT\n");
        printf("6)Consultar Depositos\n");
        printf("7)Consultar Retiros\n");
        printf("8)consultar TXT depositos\n");
        printf("9)Consultar TXT REtiros\n");
        printf("0)Exit\n");
        scanf("%d", &option);

        // printf("OPTION read: %d\n", option);
        switch (option)
        {
        case 1:
            append(capturar());
            break;
        case 2:
            prepend(capturar());
            break;
        case 3:
            consultar();
            break;
        case 4:
            printf("Numero De Cuenta: \n");
            scanf("%d", &nocta);
            menuCuenta(busquedaCuenta(nocta));
            break;
        case 5:
            consultarTxt("clientes.txt");
            break;
        case 6:
            consultarTransaccion(DEPOSITO);
            break;
        case 7:
            consultarTransaccion(RETIRO);
            break;
        case 8:
            consultarTxt("retiros.txt");
            break;
        case 9:
            consultarTxt("depositos.txt");
            break;
        case 0:
            printf("SAVING RESULTS...\n\n\n");
            saveResults();
            exit(EXIT_SUCCESS);
        default:
            printf("Error en reconocimiento de opcion\n");
            break;
        }
    }
}


struct cuenta *busquedaCuenta(int nocta)
{
    struct cuenta *cursor = First;

    while (cursor != NULL)
    {
        if (cursor->nocta == nocta)
            return cursor;
        cursor = cursor->next;
    }

    return NULL;
}

void cuentaToString(struct cuenta *actual)
{
    printf("\n\n Numero de cuenta: %d, Nombre: %s, Tipo: %s, Saldo: %d\n",
           actual->nocta,
           actual->nombre,
           actual->tipo,
           actual->saldo);
}

void transaccionToString(struct transaccion *cursor)
{
    printf("Cuenta :%8d Tipo: %s Cantidad: %10d\n",
           cursor->nocta,
           (cursor->result == RETIRO) ? "RETIRO" : "DEPOSITO",
           cursor->cantidad);
    cursor = cursor->next;
}

void append(struct cuenta *actual)
{
    if (!actual)
        return;
    if (First)
        findLast()->next = actual;
    else
    {
        First = actual;
    }
}

void prepend(struct cuenta *actual)
{
    if (!actual){
        printf("ERROR ADDING AT BEGINNING OF LIST\n");
        return;
    }
    actual->next = First;
    First = actual;
}

void menuCuenta(struct cuenta *Actual)
{
    int option;
    if (Actual)
    {
        cuentaToString(Actual);
        do
        {
            printf("1)retiro\n");
            printf("2)Deposito\n");
            printf("3)Eliminar\n");
            printf("4)Cancelar\n");
            scanf("%d", &option);

            switch (option)
            {
            case 1:
                transaccionCuenta(Actual, RETIRO);
                break;
            case 2:
                transaccionCuenta(Actual, DEPOSITO);
                break;
            case 3:
                eliminar(Actual->nocta);
                break;
            case 4:
                printf("CANCELLED\n");
                break;
            default:
                printf("OPTION NOT RECOGNIZED\n");
                break;
            }
        } while (option != 4);
    }
    else
    {
        printf("No encontrada\n");
    }
}

void transaccionCuenta(struct cuenta *Actual, enum tipo tipoTransaccion)
{
    struct transaccion *cursor, *temp;

    temp = (struct transaccion *)calloc(1, sizeof(struct transaccion));
    temp->nocta = Actual->nocta;
    temp->result = tipoTransaccion;
    temp->next = NULL;

    if (tipoTransaccion == RETIRO)
        cursor = FirstRetiro;
    else
        cursor = FirstDeposito;

    while (cursor != NULL)
    {
        cursor = cursor->next;
    }

    printf("Cantidad: \n");
    scanf("%d", &temp->cantidad);

    if (tipoTransaccion == RETIRO)
    {
        if (!strcmp(Actual->tipo, "HIPOTECA"))
        {
            printf("NO SE PUEDE RETIRAR DE HIPOTECA\n");
            free(temp);
        }
        else if (!strcmp(Actual->tipo, "INVERSION") || !strcmp(Actual->tipo, "AHORRO"))
            Actual->saldo -= temp->cantidad;
        else if (!strcmp(Actual->tipo, "CREDITO"))
            Actual->saldo += temp->cantidad;
        else
        {
            printf("ERROR EN CAPTURA\n");
            free(temp);
            return;
        }
    }
    if (tipoTransaccion == DEPOSITO)
    {
        if (!strcmp(Actual->tipo, "INVERSION") || !strcmp(Actual->tipo, "AHORRO"))
            Actual->saldo -= temp->cantidad;
        else if (!strcmp(Actual->tipo, "CREDITO") || !strcmp(Actual->tipo, "HIPOTECA"))
            Actual->saldo += temp->cantidad;
        else
            printf("ERROR EN CAPTURA\n");
        free(temp);
        return;
    }
}

struct cuenta *capturar(void)
{
    struct cuenta *temp;
    int nocta;

    printf("Numero De Cuenta: \n");
    scanf("%d", &nocta);

    if (busquedaCuenta(nocta))
    {
        printf("ERROR, cuenta existente\n");
        return NULL;
    }
    temp = (struct cuenta *)calloc(1, sizeof(struct cuenta));
    temp->nocta = nocta;
    printf("Nombre De Cuenta: \n");
    scanf("%s", temp->nombre);
    printf("Tipo De Cuenta (INVERSION, AHORRO, CREDITO, HIPOTECA): \n");
    scanf("%s", temp->tipo);
    printf("Saldo De Cuenta: \n");
    scanf("%d", &temp->saldo);
    temp->next = NULL;

    return temp;
}

struct cuenta *findLast(void)
{
    struct cuenta *cursor = First;

    while (cursor->next != NULL)
    {
        cursor = cursor->next;
    }
    return cursor;
}

void consultar(void)
{
    struct cuenta *cursor = First;
    if (cursor == NULL)
    {
        printf("EMPTY LIST\n");
    }

    while (cursor != NULL)
    {
        cuentaToString(cursor);
        cursor=cursor->next;
    }
}

void eliminar(int nocta)
{
    struct cuenta *cursor = First,*temp;
    if(cursor->nocta==nocta){
        free(First);
        First = NULL;
    }else{
        while (cursor->next)
        {
            if (cursor->next->nocta == nocta){
                temp = cursor->next->next;
                free(cursor->next);
                cursor->next = temp;
                return;
            }
            cursor = cursor->next;
        }   
    }
    
    printf("ERROR ELIMINATING ACCOUNT\n");
    
}

void saveResults()
{
    struct cuenta * cursor = First;
    FILE *fp = fopen("clientes.txt","w");
    while(cursor){
        fprintf(fp,"%d %s %s %d\n",cursor->nocta,cursor->nombre,cursor->tipo,cursor->saldo);
        cursor = cursor->next;
    }
    fclose(fp);

    struct transaccion *cursor1 = FirstDeposito;
    fp = fopen("depositos.txt", "w");
    while (cursor)
    {
        fprintf(fp,"%d %d %d\n",
               cursor1->nocta,
               cursor1->result,
               cursor1->cantidad);
        cursor1 = cursor1->next;
    }
    fclose(fp);

    struct transaccion *cursor1 = FirstRetiro;
    fp = fopen("retiros.txt", "w");
    while (cursor)
    {
        fprintf(fp, "%d %d %d\n",
                cursor1->nocta,
                cursor1->result,
                cursor1->cantidad);
        cursor1 = cursor1->next;
    }
    fclose(fp);
}

void consultarTransaccion(enum tipo tipoActual)
{
    struct transaccion *cursor;
    if (tipoActual == RETIRO)
        cursor = FirstRetiro;
    else
        cursor = FirstDeposito;

    while (cursor != NULL)
    {
        transaccionToString(cursor);
    }
}

void consultarTxt(char *filename)
{
    FILE *fp = fopen(filename, "r");
    char buffer[255];

    while (fgets(buffer, sizeof(buffer), fp))
    {
        printf("%s\n", buffer);
    }
    fclose(fp);
}

void initializeLL()
{
    FILE *fp = fopen("clientes.txt", "r");
    struct cuenta *Actual = First, *temp;
    temp = (struct cuenta *)calloc(1, sizeof(struct cuenta));
    temp->next = NULL;
    int i=0;
    

    while (EOF != fscanf(fp, "%d %s %s %d\n", &temp->nocta, temp->nombre, temp->tipo, &temp->saldo))
    {
        i++;
        append(temp);
        temp = (struct cuenta *)calloc(1, sizeof(struct cuenta));
        temp->next = NULL;
    }
    printf("%d\n",i);
    free(temp);
    fclose(fp);
}