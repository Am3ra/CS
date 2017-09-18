n = int(input("Input a number: "))
def dict(n):
    l={x+1: (x+1)**2 for x in range(n)}
    return l
print(dict(n))
