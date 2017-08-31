def ipname(a):
    length= a[0]
    intermediate= []
    results = []
    del a[0]

    for i in a:
        print str(i), 2

        if (i == 0):
            results = results + ["0.0.0.0"]

        intermediate = intermediate + [str(i)] #.zfill(32)



    return intermediate


print ipname([4, 00000000000000000000000000000000, 0000001110000000111111111111111, 11001011100001001110010110000000, 01010000000100000000000000000001])
