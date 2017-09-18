def factorial(x):
    i=1
    j=1
    while(i<x):
        i=i+1
        j=j*i
    return j
a = int(input("Please choose a number: "))
print(factorial(a))
