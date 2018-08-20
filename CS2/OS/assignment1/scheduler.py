import sys
from operator import itemgetter, attrgetter

#FIRST COME FIRST SERVE


def FCFS(process_list):
    # Sorts array of arrays first by the second element, arrival time, then by PID
    sorted(process_list, key=itemgetter("arrival_time"))
    print(process_list,"SORTED BY ARRIVAL TIME")



a=[]
with open(sys.argv[1]) as f:
  while True:
    c = f.read(1)
    if not c:
      print("End of file")
      break
    elif c == "#":
        f.readline()
    elif c.isdigit():
        a.append(c)

quantum = a[0:1][0]
a = a[1:]
#whole process may be simplified in input process
#END OF INPUT PROCESS
final_process = [] #array of all processes
print(a, "INITIAL PROCESS LIST")
while len(a)>0:
    temp = a[:4]
    final_process.append({"PID": int(temp[0]), "arrival_time": int(temp[1]), "cpu_burst":int(temp[2]), "priority": int(temp[3])})
    a = a[4:]
print(final_process, quantum)
#END ORGANIZATION AND PROCESSING OF DATA


#Start of testing
FCFS(final_process)

