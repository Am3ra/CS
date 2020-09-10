def factorial(x):
    j=1
    for i in range(x):
        j*=(i+1)
    return j
print(factorial(int(input("Please choose a number: "))))
