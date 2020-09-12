#include <iostream>
#include <cstring>
#include <fstream>
#include <vector>
#include <algorithm>
#include<time.h>
#include <ctime>

using namespace std;
 
#define INF 9999999
#define edge pair<int,int>


float prim(string arch)
{
    // Lectura de archivo
    int cantidadAristas, nodo1, nodo2, peso, cantidadNodos;
    unsigned inicio, fin;
    double t = 0;
    ifstream archivo;
    archivo.open(arch, ios::in);
    archivo >> cantidadNodos;
    int **G = new int *[cantidadNodos];
    for (int i = 0; i < cantidadNodos; ++i)
    {
        G[i] = new int[cantidadNodos];
    }
    // Creación de grafo
    archivo >> cantidadAristas;
    for (int i = 0; i < cantidadAristas; i++)
    {
        archivo >> nodo1;
        archivo >> nodo2;
        archivo >> peso;
        G[nodo1][nodo2] = peso;
        G[nodo2][nodo1] = peso;
    }

    int costoTotal = 0;
    int selected[cantidadNodos];
    memset(selected, false, sizeof(selected));
    cantidadAristas = 0;
    selected[0] = true;
    cout << "Arista"
         << " : "
         << "Peso";
    cout << endl;

    while (cantidadAristas < cantidadNodos - 1)
    {
        int min = INF;
        int x = 0;
        int y = 0;
        for (int i = 0; i < cantidadNodos; i++)
        {
            if (selected[i])
            {
                inicio = clock();
                for (int j = 0; j < cantidadNodos; j++)
                {
                    if (!selected[j] && G[i][j])
                    {
                        if (min > G[i][j])
                        {
                            min = G[i][j];
                            x = i;
                            y = j;
                            costoTotal = costoTotal + G[x][y];
                        }
                    }
                }
                fin = clock();
            }
        }
        cout << "(" << x << " , " << y << " , " << G[x][y] << ")";
        cout << endl;
        selected[y] = true;
        cantidadAristas++;
    }

    t = (double(inicio - fin) / CLOCKS_PER_SEC);
    cout << "Tiempo de ejecucion :"
         << " " << t << " mseg"
         << "\n";
    cout << "Costo Total: " << costoTotal << "\n";
}

int main () {


    prim("P3Edges0.txt");
  //miMST.kruskalUF("P3Edges0.txt");
   
    return 0;
}