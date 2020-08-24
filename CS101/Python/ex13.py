# Question 13
# Level 2
#
# Question:
# Write a program that accepts a sentence and calculate the number of letters and digits.
# Suppose the following input is supplied to the program:
# hello world! 123
# Then, the output should be:
# LETTERS 10
# DIGITS 3

a = input()
numbers = 0
letters = 0

for i in a:
    if i.isdigit():
        numbers += 1

    elif i.isalpha():
        letters += 1
        print(i)

print("Numbers: ", numbers, "\nLetters: ", letters)
#done!
