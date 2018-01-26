def permutations(string):
    perms = []
    # print(string)
    for i in enumerate(string):

        # print(i)
        if i[0] == 0:
            perms.append(i[1])
            continue
        # print(perms)
        for j in perms:
            curr = []
            print(i, j, curr)

            for k in range(len(j)):
                now = j
                print(i, j, k, curr, j.split())
                # curr.append("".join(j.split().insert(k, i[1])))
        perms = curr


    return perms

print(permutations("as"))
