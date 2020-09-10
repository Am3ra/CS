import getpass
import os
os.system("clear")
pw = getpass.getpass()
minuscula=0
mayuscula=0
numero=0
especial =0
if (len(pw)<5) or (len(pw)>15):
    print("Error, out of range")
for i in pw:
    if (ord(i)>47) and (ord(i)<58):
        numero = 1
    elif (ord(i)>64) and (ord(i)<91):
        mayuscula = 1
    elif (ord(i)>96) and (ord(i)<123):
        minuscula = 1
    else:
        especial = 1
if (minuscula == 1 and mayuscula == 0 and numero == 0 and especial ==0) or (minuscula == 0 and mayuscula == 1 and numero == 0 and especial ==0) or (minuscula == 0 and mayuscula == 0 and numero == 1 and especial ==0):
    print("nivel 1")
elif (minuscula == 1 and mayuscula == 1 and numero == 0 and especial ==0) or (minuscula == 1 and mayuscula == 0 and numero == 1 and especial ==0) or (minuscula == 0 and mayuscula == 1 and numero == 1 and especial ==0):
    print("nivel 2")
elif(minuscula == 1 and mayuscula == 0 and numero == 0 and especial ==1) or (minuscula == 0 and mayuscula == 1 and numero == 0 and especial ==1) or (minuscula == 0 and mayuscula == 0 and numero == 1 and especial ==1):
    print("nivel 3")
elif(minuscula == 1 and mayuscula == 1 and numero == 1 and especial ==0):
    print("nivel 4")
elif(minuscula == 1 and mayuscula == 1 and numero == 1 and especial ==1):
    print("nivel 5")
print(pw)
