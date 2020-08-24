# Taken from http://www.practicepython.org/exercise/2017/01/24/33-birthday-dictionaries.html
import json
a = {"a": "cool", "b":"awesome"}

print("Welcome to the birthday dictionary. We know the birthdays of: ")
print( *list(a.keys()), sep='\n')
b = input("\nWho's birthday do you want to look up? ")
print("%s\'s birthay is %s"%(b,a[b]))
