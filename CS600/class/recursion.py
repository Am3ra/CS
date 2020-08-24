# Recursion needs two things:
# 1: A base case (if x then y)
# 2: A Recursive (inductive) case
#       a way to simplify the problem after simple ops.


# 1: factorial

def factorial(fact):
    if fact <= 1:  # Base Case: x=1
        return 1
    else:
        return fact * factorial(fact-1)


print(factorial(6))


def exponential(b, n):
    if n == 1:
        return b
    else:
        return b * exponential(b, n-1)


print(exponential(2, 5))


def palindrome(strPalindrome):
    if len(strPalindrome) <= 1:
        return True
    else:
        return strPalindrome[0] == strPalindrome[-1] and palindrome(strPalindrome[1:-1])


print(palindrome('racecar'))


def fibonacci(n):
    # Assumes input > 0
    if n<=1:
        return 1
    else:
        return fibonacci(n-1)+fibonacci(n-2)

#rabbits model
#1 pair of rabits start
#sexual maturity and gestation period of 1 month
#never die
#always produces 1 pair
