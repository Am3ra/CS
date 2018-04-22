# A Kolakoski sequence(A000002) is an infinite sequence of symbols {1, 2} that is its own run-length encoding. It alternates between "runs" of symbols. The sequence begins:

# 12211212212211211221211212211...
# The first three symbols of the sequence are 122, which are the output of the first two iterations. After this, on the i-th iteration read the value x[i] of the output(one-indexed). If i is odd, output x[i] copies of the number 1. If i is even, output x[i] copies of the number 2.

# There is an unproven conjecture that the density of 1s in the sequence is 1/2 (50 % ). In today's challenge we'll be searching for numerical evidence of this by tallying the ratio of 1s and 2s for some initial N symbols of the sequence.

# Input Description
# As input you will receive the number of outputs to generate and tally.

# Output Description
# As output, print the ratio of 1s to 2s in the first n symbols.

# Sample Input
# 10
# 100
# 1000
# Sample Output
# 5: 5
# 49: 51
# 502: 498
# Challenge Input
# 1000000
# 100000000
# Bonus Input
# 1000000000000
# 100000000000000
# Bonus Hints
# Since computing the next output in the sequence depends on previous outputs, a naive brute force approach requires O(n) space. For the last bonus input, this would amount to TBs of data, even if using only 1 bit per symbol. Fortunately there are smarter ways to compute the sequence(1, 2).

# Credit
# This challenge was developed by user / u/skeeto, many thanks! If you have a challenge idea please share it in / r/dailyprogrammer_ideas and there's a good chance we'll use it.


def Kolakoski(n):
    kolInit = [1,2,2]

    if n<=3:
        return kolInit[n-1]
    else:
        pass

