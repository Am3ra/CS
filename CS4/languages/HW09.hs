-- ====================
-- Complete the following functions and submit your file to Canvas.
-- ====================
-- Do not change the names of the functions. 
-- Do not change the number of arguments in the functions.
-- If your file cannot be loaded by the Haskell compiler, your submission may be cancelled. 
-- Then, submit only code that works.
-- ====================
-- Grading instructions:
-- There is a series of test cases for each function. In order to state that your function
-- "works as described", your output must be similar to the expected one in each case.

-- === invert ===

invert :: [t] -> [t]
invert [] = []
invert (x:y) = invert y ++ [x]

-- === or ===

listor :: [Int] -> [Int] -> [Int]
listor [] [] = []
listor (1:y) (1:w) = [1] ++ listor y w
listor (1:y) (0:w) = [1] ++ listor y w
listor (0:y) (0:w) = [0] ++ listor y w
listor (0:y) (1:w) = [1] ++ listor y w
listor (_:y) (_:w) = error "not 0 or 1"

-- === multiples ===

multiples :: [Int] -> Int -> [Int]
multiples (x:y) z = 
    if 
        mod x z == 0
    then
        [x] ++ multiples y z
    else
        multiples y z
multiples [] _ = []

-- === differences ===

differences :: [Int] -> [Int]
differences (x:y) = differences2 ([x]++y) (y++[x])
differences [] = []

differences2 :: [Int] -> [Int] -> [Int]
differences2 (x:y) (z:w) = [abs (z-x)] ++ differences2 y w
differences2 [] [] = []

-- === toBinaryString ===

toBinaryString :: Int -> [Char]
toBinaryString 0 = "0" 
toBinaryString x = invert (aux x)

aux :: Int -> [Char]
aux 0 = ""
aux x = if rem x 2 == 0 
    then '0' : aux (div x 2) 
    else ('1' : aux (div x 2)) 


-- === modulo ===

modulo :: Int -> Int -> Int
modulo x y = 
    if
        x >= y
    then
        modulo (x-y) y
    else
        x

-- === evaluate ===

evaluate :: [Double] -> Double -> Double
evaluate x y = auxpoly (invert x) y 0

auxpoly :: [Double] -> Double -> Integer -> Double
auxpoly  [] x y = 0
auxpoly  (a:b) x y = a * (x^y) + (auxpoly b x (y+1))
-- === cleanString ===

cleanString :: [Char] -> [Char]
cleanString [] = [] 
cleanString (x:[]) = [x]
cleanString (x:y:z) = 
    if 
        x == y
    then
        cleanString( y : z)
    else
       x : cleanString (y:z)



-- === iSort ===

iSort :: [Int] -> [Int]
iSort [] = []
iSort [x] = [x]
iSort (x:y) = iSortAux x (iSort y)


iSortAux :: Int -> [Int] -> [Int]
iSortAux x [] = [x] 
iSortAux x (y:z) = 
    if x < y
    then 
        x : (y : z)
    else
        y : (iSortAux x z)
-- === Test cases ===

main = do 
    print "=== invert ==="
    print $ invert ([] :: [Int])-- []
    print $ invert [1, 2, 3, 4, 5] -- [5,4,3,2,1]
    print $ invert "hello world!" -- "!dlrow olleh"
    print "=== listor ==="
    print $ listor [1, 1, 0] [0, 1, 0] -- [1,1,0]
    print $ listor [1, 0, 1, 0] [0, 0, 1, 1] -- [1,0,1,1]
    print $ listor [1, 0, 1, 0, 1] [1, 1, 1, 0, 0] -- [1,1,1,0,1]
    print "=== multiples ==="
    print $ multiples [2, 4, 5, 6] 2 -- [2,4,6]
    print $ multiples [9, 27, 8, 15, 4] 3 -- [9,27,15]
    print $ multiples [9, 8, 17, 5] 6 -- []
    print "=== differences ==="
    print $ differences [1, 2, 4, 8, 20] -- [1,2,4,12,19]
    print $ differences [5, 9, 13, 27, 100, 91, 4] -- [4,4,14,73,9,87,1]
    print $ differences [99] -- [0]
    print $ differences [] -- [] 
    print "=== toBinaryString ==="
    print $ toBinaryString 0 -- "0"
    print $ toBinaryString 1 -- "1"
    print $ toBinaryString 7 -- "111"
    print $ toBinaryString 32 -- "100000"
    print $ toBinaryString 1024 -- "10000000000"
    print "=== modulo ==="
    print $ modulo 10 2 -- 0
    print $ modulo 15 4 -- 3
    print $ modulo 20 9 -- 2
    print $ modulo 77 10 -- 7
    print "=== evaluate ==="
    print $ evaluate ([] :: [Double]) 100 -- 0.0
    print $ evaluate [2, 3.1, 10, 0] 2 -- 48.4
    print $ evaluate [10, 0] 2 -- 20.0
    print $ evaluate [1, 2, 3, 4, 5] 3 -- 179.0
    print "=== cleanString ==="
    print $ cleanString ([] :: String) -- ""
    print $ cleanString "yyzzza" -- "yza"
    print $ cleanString "aaaabbbccd" -- "abcd"
    print "=== iSort ==="
    print $ iSort [] -- []
    print $ iSort [1] -- [1]
    print $ iSort [1, 6, 3, 10, 2, 14] -- [1,2,3,6,10,14]