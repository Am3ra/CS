from zipfile import *



zip_archive = ZipFile("Downloads/channel.zip", "r")

x = zip_archive.comment()

print(x)


#
# while True:
#     filename = "Downloads/channel/"+str(x)+".txt"
#     file = open(filename, "r")
#     for line in file:
#         print(line)
#         x = line.split()[3]
#     print(x)
