'''
Solve a bunch of problems. Make em functions, might use it later.
'''


def diff_seq(seq):
    '''1) Write a Python function that takes a sequence of numbers
     and determines if all the numbers are different from each other.
     if so, return "all are different"
     else, return "FAKE NEWS"
    '''
    for i in enumerate(seq):
        for j in enumerate(seq):
            if j != i:
                if seq[j] == seq[i]:
                    return "FAKE NEWS"
    return "all are different"

def possible_substrings(strings):
    '''
    return all possible substrings of given string
    '''
print(possible_substrings("aeiou"))