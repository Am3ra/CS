# Question 7
# Level 2
#
# Question:
# Write a program which takes 2 digits, X,Y as input and generates a 2-dimensional array. The element value in the i-th row and j-th column of the array should be i*j.
# Example
# Suppose the following inputs are given to the program:
# 3,5
# Then, the output of the program should be:
# [[0, 0, 0, 0, 0], [0, 1, 2, 3, 4], [0, 2, 4, 6, 8]]
#
# Hints:
# Note: In case of input data being supplied to the question, it should be assumed to be a console input in a comma-separated form.

l = input("Write dimensions of array: ")
l = l.split(",")
l = list(map(int, l))
arr = []
for i in range(l[0]):
    arr.append([])
    for j in range(l[1]):
        arr[i].append(i*j)
print(arr)
