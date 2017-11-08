# view-source:http://www.pythonchallenge.com/pc/def/equality.html


a = []
while True:
    s = input()
    if not s:
        break
    for i in list(s):
        a.append(i)

for i in range(len(a)):
    if (ord(a[i]) > 91 ) and (ord(a[i+1]) < 91 ) and (ord(a[i+2]) < 91 ) and (ord(a[i+3]) < 91 )and (ord(a[i+4]) > 91  ) and (ord(a[i+5]) < 91) and (ord(a[i+6]) < 91 ) and (ord(a[i+7]) < 91) and (ord(a[i+8]) > 91):
        print(a[i+4])
