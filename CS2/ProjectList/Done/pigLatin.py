def convertToPigLatin(inputString):
    # inputString = [[j for j in i] for i in inputString.split(" ") ]
    # print(inputString)


    # seperate into words
    inputString = inputString.split(" ")
    # Move initial consonants to end
    for index, word in enumerate(inputString):
        for i in word:
            if i.lower() in ["a","e","i","o","u"]:
                break
            else:
                word = inputString[index] = word[1:]+i.lower()
        # print("Word: "+word)

        # Add suffix    
        inputString[index] = word+ "ay"

    print(" ".join(inputString))
    # print(inputString)
convertToPigLatin(input("Phrase to covert: "))