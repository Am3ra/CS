from zipfile import *

num = 90052
comments = []

while True:
    print(num)
    filename = "Downloads/channel/"+str(num)+".txt"
    archive = open(filename, "r")
    data = archive.readline()
    print(data)
    num = int(data.split()[3])
    comments.append(archive.getinfo())
print(comments)




print(x)


#
# while True:
#     filename = "Downloads/channel/"+str(x)+".txt"
#     file = open(filename, "r")
#     for line in file:
#         print(line)
#         x = line.split()[3]
#     print(x)
