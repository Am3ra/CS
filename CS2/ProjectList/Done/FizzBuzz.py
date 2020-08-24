for i in range(1,101):
    output = ""
    if i%3 is 0:
        output += "Fizz"
    if i%5 is 0:
        output += "Buzz"
    if output is "":
        output = i
    print(output)
