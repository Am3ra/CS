#Q = sqrt([100 * D ]/30)
import math
d = input("Choose a number or numbers: ")
d= d.split(',')
for i in d:
    i = math.floor(math.sqrt((100*float(i))/30))
    print(i)
