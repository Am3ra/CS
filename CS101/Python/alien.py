t = int(input())  # read a line with a single integer
def translate(input_string, source_language, target_language):
    input_string = input_string[::-1]
    m = len(input_string)
    n = len(source_language)
    l = len(target_language)
    sumtotal = 0
    translation = ""
    z=0
    x=0
    for i in range(m):
        sumtotal+= (n**i)*source_language.index(input_string[i])
    while (l**(z+1) <= sumtotal):
        z+=1
    while (z>=0):
        if((l**z)*(x+1)<=sumtotal):
            x+=1
        else:
            translation += target_language[x]
            sumtotal -= (l**z)*(x)
            z-=1
            x=0
    return translation

for i in range(1, t + 1):
  input_string,source_language,target_language = [s for s in input().split(" ")]  # read a list of strings, 3 in this case
  translation = translate(input_string,source_language,target_language)
  print("Case #%d: %s"%(i,translation))
