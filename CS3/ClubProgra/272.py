from sys import stdin
import re


for line in stdin:
    line = line.rstrip('\n')
    line = re.sub('"(.*?)"', r"``\1''",line)
    line = re.sub('"', r"``",line)
    print(line.rstrip('\n'))