#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>
using std::cin;
using std::cout;
#include "StacksDP.cpp"

#include <fstream>
std::ifstream infile("clientes.txt");

using namespace std;

class Stacks
{
    private:
        StacksDP stack;
        string data;

    public:
        Stacks()
        {
            cout << "CONSTRUCTOR";
            if (infile.is_open())
            {
                cout << "OPEN\n";
                std::string line;
                while (getline(infile, line))
                {
                    cout<<line+"\n";
                    stack.push(line);
                }
                infile.close();
            }
        }
        void opciones()
        {
            int opcion = 0;
            string respuesta = "";
            string nombre = "";
            do
            {
                cout << "\n\nStacks\n";
                cout << "1) Push\n";
                cout << "2) Pop\n";
                cout << "3) Desplegar\n";
                cout << "5) Salir";
                cout << "\nOpcion: ";
                cin >> opcion;

                switch (opcion)
                {
                case 1:
                    data = obtenerDatos();
                    respuesta = stack.push(data);
                    cout << respuesta + "\n";
                    break;
                case 2:
                    respuesta = stack.pop();
                    cout << respuesta;
                    break;
                case 3:
                    respuesta = stack.desplegar();
                    cout << respuesta;
                    break;
                case 5:
                    cout << "BYE BYE!\n\n";
                    writeFile();
                    break;
                default:
                    cout <<"Error en reconocimiento de opcion\n\n";
                    break;
                }
            } while (opcion != 5);
        }

        void writeFile(){
            std::ofstream outfile("clientes.txt");
            outfile<<stack.desplegar();
        }

        string obtenerDatos(void){
            string data;
            cout << "Nombre: ";
            getline(cin, data); //Activa el segundo getLine la primera lectura no se realiza sin éste.
            getline(cin, data);
            return data;
        }
};

int main()
{
    Stacks objeto;
    objeto.opciones();
}
