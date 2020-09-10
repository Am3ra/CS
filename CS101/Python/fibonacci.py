x=0
while x<1 or x>100:
    x = 0
    x = int(input("Choose a number 1-100: "))
    if x<1 or x>100:
        print("Number out of bounds")
b=0
m=1
l=1
total=0
print(0)
while b + m <= x:
    l=b+m
    print(l)
    b=m
    m=l
    total += l
print("Total es: %d"%total)
