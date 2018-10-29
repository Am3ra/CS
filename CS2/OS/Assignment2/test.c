#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char Datos[80];
char NoCuenta[80];
char TipoCuenta[80];
int Encontrado;
FILE *Archivo;

enum valores
{
	NOCTA,
	NOMBRE,
	TIPO
};

void EncontrarNoCuenta()
{
	char Cliente[80];
	char NoC[20];
	char Nom[20];
	char Tip[20];
	char Sal[20];

	int cont;

	cont = 0;
	Encontrado = 0;

	strcpy(Cliente, Datos);

	Archivo = fopen("7_BaseAccenture.txt", "r");

	while (fgets(Cliente, 80, Archivo) > 0 && cont == 0)
	{

		strcpy(NoC, strtok(Cliente, "_"));
		strcpy(Nom, strtok(NULL, "_"));
		strcpy(Tip, strtok(NULL, "_"));
		strcpy(Sal, strtok(NULL, "\n"));

		if (strcmp(NoCuenta, NoC) == 0)
		{
			Encontrado = 1;
			cont = 1;
		}
	}
	fclose(Archivo);
}

void Capturar()
{
	Archivo = fopen("7_BaseAccenture.txt", "a");

	fputs(Datos, Archivo);

	fclose(Archivo);
}

void Error()
{
	system("cls");
	printf("\nYA EXISTE EL NUMERO DE CUENTA INTRODUCIDO\n\n");
	system("pause");
	system("cls");
	main();
}

void ObtenerDatos()
{

	char Nombre[80];
	char SaldoCuenta[80];

	Encontrado = 0;

	printf("\nNUMERO DE CUENTA: ");
	gets(NoCuenta);
	gets(NoCuenta);

	printf("\nNOMBRE: ");
	gets(Nombre);

	printf("\n\n [INVERSION, AHORRO, CREDITO, HIPOTECA]\nTIPO DE CUENTA: ");
	gets(TipoCuenta);

	printf("\nSALDO DE LA CUENTA: ");
	gets(SaldoCuenta);

	strcat(Datos, NoCuenta);
	strcat(Datos, "_");
	strcat(Datos, Nombre);
	strcat(Datos, "_");
	strcat(Datos, TipoCuenta);
	strcat(Datos, "_");
	strcat(Datos, SaldoCuenta);
	strcat(Datos, "\n");

	EncontrarNoCuenta();

	if (Encontrado == 0)
	{
		printf("\n%s\n", Datos);
		Capturar();
		strcpy(Datos, "");
	}
	if (Encontrado == 1)
	{
		strcpy(Datos, "");
		Error();
	}
}

void ConsultaGeneral()
{
	char NoC[20];
	char Nom[20];
	char Tip[20];
	char Sal[20];

	Archivo = fopen("7_BaseAccenture.txt", "r");

	while (fgets(Datos, 80, Archivo) > 0)
	{

		strcpy(NoC, strtok(Datos, "_"));
		strcpy(Nom, strtok(NULL, "_"));
		strcpy(Tip, strtok(NULL, "_"));
		strcpy(Sal, strtok(NULL, "\n"));

		printf("\n%s		%s		%s		%s\n", NoC, Nom, Tip, Sal);
	}

	fclose(Archivo);
}

int BusquedaGeneral(int valor)
{
	char NoC[20];
	char Nom[20];
	char Tip[20];
	char Sal[20];

	while (fgets(Datos, 80, Archivo) > 0)
	{

		strcpy(NoC, strtok(Datos, "_"));
		strcpy(Nom, strtok(NULL, "_"));
		strcpy(Tip, strtok(NULL, "_"));
		strcpy(Sal, strtok(NULL, "\n"));

		switch (valor)
		{
			{
			case NOCTA:
				if (strcmp(NoCuenta, NoC) == 0)
					printf("\n%s		%s		%s		%s\n", NoC, Nom, Tip, Sal);
				break;
			case TIPO:
				if (strcmp(TipoCuenta, Tip) == 0)
					printf("\n%s		%s		%s		%s\n", NoC, Nom, Tip, Sal);
				break;
			default:
				printf("Error culo\n\n\n");
				break;
			}
		}
	}
}

void ConsultarPorNoCuenta()
{
	char NoC[20];
	char Nom[20];
	char Tip[20];
	char Sal[20];

	int cont = 0;

	Archivo = fopen("7_BaseAccenture.txt", "r");

	gets(TipoCuenta);
	gets(TipoCuenta);
	printf("YES\n");
	BusquedaGeneral(NOCTA);
	fclose(Archivo);
}

void ConsultarPorTipoCuenta()
{
	char NoC[20];
	char Nom[20];
	char Tip[20];
	char Sal[20];

	int cont;
	cont = 0;

	Archivo = fopen("7_BaseAccenture.txt", "r");

	printf("\n [INVERSION, AHORRO, CREDITO, HIPOTECA]\nTIPO DE CUENTA: ");
	gets(TipoCuenta);
	gets(TipoCuenta);

	while (fgets(Datos, 80, Archivo) > 0)
	{

		strcpy(NoC, strtok(Datos, "_"));
		strcpy(Nom, strtok(NULL, "_"));
		strcpy(Tip, strtok(NULL, "_"));
		strcpy(Sal, strtok(NULL, "\n"));

		if (strcmp(TipoCuenta, Tip) == 0)
		{
			printf("\n%s		%s		%s		%s\n", NoC, Nom, Tip, Sal);
			cont = 1;
		}
	}

	if (cont == 0)
	{
		printf("\nEL TIPO DE CUENTA INTRODUCIDO NO SE ENCUENTRA, POSIBLE ERROR DE SINTAXIS.\n");
	}

	fclose(Archivo);
}

void Consultar()
{
	int opcion;

	system("cls");
	printf("CONSULTA\n");
	printf("[1] CONSULTA GENERAL\n");
	printf("[2] CONSULTA POR NUMERO DE CUENTA\n");
	printf("[3] CONSULTA POR TIPO DE CUENTA\n");
	printf("OPCION: ");
	scanf("%i", &opcion);

	switch (opcion)
	{
	case 1:
		ConsultaGeneral();
		break;
	case 2:
		ConsultarPorNoCuenta();
		break;
	case 3:
		ConsultarPorTipoCuenta();
		break;
	default:
		system("cls");
		printf("\nEL VALOR INTRODUCIDO NO CORRESPONDE A UN VALOR DEFINIDO [1,2,3].\n\n");
		break;
	}
}

void Opciones()
{
	int opcion;

	do
	{
		printf("ACCENTURE\n");
		printf("[1] CAPTURAR DATOS\n");
		printf("[2] CONSULTAR DATOS\n");
		printf("[3] Exit\n");
		printf("Opcion: ");
		scanf("%i", &opcion);

		switch (opcion)
		{
		case 1:
			ObtenerDatos();
			break;
		case 2:
			Consultar();
			break;
		case 3:
			system("cls");
			printf("\nFIN :D\n\n");
			exit(0);
		default:
			system("cls");
			printf("\nEL VALOR INTRODUCIDO NO CORRESPONDE A UN VALOR DEFINIDO [1,2,3].\n\n");
			break;
		}
		system("pause");
		system("cls");
	} while (opcion != 3);
}

int main()
{
	Opciones();
	return 0;
}