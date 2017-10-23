import os

arr = []

a = "a"
while (a>="a") or (a<="j") or (ord(a) == 27):
    os.system('clear')  # For Linux/OS x
    print("a) Capturar Numeros\n")
    print("b) Mostrar valores capturados\n")
    print("c) Media/Promedio\n")
    print("d) Mayor\n")
    print("e) Menor\n")
    print("f) Mediana\n")
    print("g) Moda\n")
    print("h) Desviacion estandar\n")
    print("i) Menor a mayor\n")
    print("j) Mayor a menor\n")
    a = input()
    if (a>="a") or (a<="j") or (ord(a) == 27):
        if a=="a":
            os.system('clear')
            arr=[]
            a=1
            while(a!=0) and a.isdigit():
                a = input()
                arr.append(a)
            input("\nPress enter to continue")
        elif a=="b":
            print(arr)
            input("\nPress enter to continue")
        elif a=="c":
            os.system('clear')
            print(sum(arr)/len(arr))
        elif a=="d":
            x = 0
            for i in arr:
                if i > x:
                    x = i
            print(x)
        elif a=="e":
            menor()
        elif a=="f":
            mediana()
        elif a=="g":
            moda()
        elif a=="h":
            D_s()
        elif a=="i":
            menorMayor()
        elif a=="j":
            mayormenor()
