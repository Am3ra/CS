
# 6.00 Problem Set 3
#
# Hangman
#


# -----------------------------------
# Helper code
# (you don't need to understand this helper code)
import random
import string

WORDLIST_FILENAME = "words.txt"

def load_words():
    """
    Returns a list of valid words. Words are strings of lowercase letters.

    Depending on the size of the word list, this function may
    take a while to finish.
    """
    print "Loading word list from file..."
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r', 0)
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    wordlist = string.split(line)
    print "  ", len(wordlist), "words loaded."
    return wordlist

def choose_word(wordlist):
    """
    wordlist (list): list of words (strings)

    Returns a word from wordlist at random
    """
    return random.choice(wordlist)

# end of helper code
# -----------------------------------

def word_display(guessed, guess, lengthword):
    eles = list(enumerate(guessword))

    for i in eles:


    print eles
    return

# actually load the dictionary of words and point to it with
# the wordlist variable so that it can be accessed from anywhere
# in the program
wordlist     = load_words()
guessword    = choose_word(wordlist)
lengthword   = len(guessword)
numguesses   = 10
iscomplete   = False
letters      = []
guessed      = []
current_word = ""

for i in range(97, 123):
    letters += chr(i)

print "-----------------"
print "Welcome to the game, Hangman!"
print "I am thinking of a word that is %d letters long." % lengthword

while numguesses > 0:
    avlets = ""
    for item in letters:
        avlets += item

    print "Number of guesses: " + str(numguesses)
    print "Available letters: " + avlets
    guess = str.lower(raw_input("Guess a letter: "))
    word_display(guessed,guess, guessword)

    try:
        letters.pop(letters.index(guess))
    except ValueError:
        print "Letter already guessed. Guess Again."
        numguesses += 1
    print "-----------------"


    numguesses -= 1 #TODO: change this depending on answer.



if iscomplete == False:
    print "Sorry!"
    print "GAME OVER"
    print "Correct word was: " + guessword
