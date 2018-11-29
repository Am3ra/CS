#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#include <string>
using std::string;

#include <iostream>
using std::cin;
using std::cout;
using std::stringstream;

#include <sstream>


using namespace std;

class Nodo
{
    private:
        string info;
        Nodo *next;
    public:
        Nodo(string info){
            this->setString(info);
        }
        string getString(void){
            return this->info;
        }

        void setString(string info)
        {
            this->info = info;
        }

        Nodo *getNext(void){
            return this->next;
        }

        void setNext(Nodo *next){
            this->next = next;
        }
};

