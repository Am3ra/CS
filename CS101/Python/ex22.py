# Question 22
# Level 3
#
# Question:
# Write a program to compute the frequency of the words from the input. The output should output after sorting the key alphanumerically.
# Suppose the following input is supplied to the program:
# New to Python or choosing between Python 2 and Python 3? Read Python 2 or Python 3.
# Then, the output should be:
# 2:2
# 3.:1
# 3?:1
# New:1
# Python:5
# Read:1
# and:1
# between:1
# choosing:1
# or:2
# to:1
#
# Hints
# In case of input data being supplied to the question, it should be assumed to be a console input.



### Modified for : http://www.pythonchallenge.com/pc/def/ocr.html
dic={}
a = []
while True:
    s = input()
    if not s:
        break
    for i in list(s):
        a.append(i)

for i in a:
    if i in dic:
        dic[i]+=1
    else:
        dic[i]=1

print(sorted(dic.items(), key=lambda value: value[1]))
