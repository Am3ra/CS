Notas importantes del proyecto en su forma actual:

COMO COMPILAR:
    para modo debug: gcc -DDEBUG scheduler.c -o a.out && ./a.out process4.txt

TODO:
    
    Probar funcion destructora de listas. Relativamente facil.

    Mejorar funcion organizadora para poder lidiar con datos iguales. (Tomar PID en caso de que CPU_BURST sea igual, etc. Facil.

    Generalizar las funciones hechas, haciendo la estructura de la lista simplemente un apuntador a los datos y otro al siguiente nodo. (DIFICIL/FUERA DEL ALCANCE)

    Finalizar los algoritmos de administración de tareas. Lol.

    Hacer los casos de DEBUG en el scheduler.c

    En el impresor de resultados, determinar cuantos digitos/decimales necesarios.

    Normalizar los nombres de las funciones.