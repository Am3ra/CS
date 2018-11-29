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
#include "StacksAD.cpp"

using namespace std;


class StacksDP
{
private:
    Nodo *FirstNode, *tempNode;
public:
    string push(string info){
        if(FirstNode == NULL){
            FirstNode = new Nodo(info);
            FirstNode->setNext(NULL);
            return "Exitosamente Guardado: "+info;
        }
        else{
            tempNode = FirstNode;
            FirstNode = new Nodo(info);
            FirstNode->setNext(tempNode);
            return "Exitosamente Guardado: " + info;
        }
    }
    string pop(void){
        
        if (FirstNode == NULL) {
            return "EMPTY LIST";
        }
        
        string result = FirstNode->getString();
        FirstNode = FirstNode->getNext();
        return result;
    }
    string desplegar(void){
        string result ="";
        
        if (FirstNode == NULL) {
            return "NULL LIST";
        }
        
        Nodo *cursor = FirstNode;
        while(cursor!=NULL){
            result += cursor->getString() +"\n";
            cursor = cursor->getNext();
        }
        return result;
    }
    void getData(void);
    void saveData(void);

};

