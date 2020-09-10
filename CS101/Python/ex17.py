# Question 17
# Level 2
#
# Question:
# Write a program that computes the net amount of a bank account based a transaction log from console input. The transaction log format is shown as following:
# D 100
# W 200
# ¡­
# D means deposit while W means withdrawal.
# Suppose the following input is supplied to the program:
# D 300
# D 300
# W 200
# D 100
# Then, the output should be:
# 500
#
# Hints:
# In case of input data being supplied to the question, it should be assumed to be a console input.
a=[]
total = 0
while True:
    s = input()
    if not s:
        break
    a.append(s.split(" "))
for i in a:
    if i[0] == "D":
        total += int(i[1])
    else:
        total -= int(i[1])
print(total)

#Done!
