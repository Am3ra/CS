#include <string>
using std::string;

#include <iostream>
using std::cin;
using std::cout;

class LibroGUI
{


    private:
        string titulo;
        string autor;
        string editorial;
    
    public:
        void opciones(){
            int opcion;

            do
            {
                cout << "Biblioteca Tec\n";
                std::cout << "1)Capturar Datos" << '\n';
                std::cout << "2)Consultar" << '\n';
                std::cout << "5)exit" << '\n';
                std::cin >> opcion;

            } while(opcion!=5);
        }
    
};

int main(int argc, char const *argv[])
{
    // LibroGUI objeto;
    // objeto.opciones();
    LibroGUI *objeto = new LibroGUI;
    objeto->opciones();
    return 0;
}
