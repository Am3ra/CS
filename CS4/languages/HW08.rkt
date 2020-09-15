#lang racket
;; ====================
;; Complete the following functions and submit your file to Canvas.
;; ====================
;; Do not change the names of the functions. 
;; Do not change the number of arguments in the functions.
;; If your file cannot be loaded by the Racket interpreted, your submission may be cancelled. Then, submit only code that works.
;; ====================
;; Grading instructions:
;; There is a series of test cases for each function. In order to state that your function "works as described", your output must be similar to the expected one in each case.

;; === maskedsum ===

(define (maskedSum lst mask)
  (apply +(filter (lambda (x) (not (null? x))) (filter-map (lambda (x y)
    (if y
      x
      null
    )
  
  ) lst mask)))
)

(display "=== maskedsum ===\n")
(maskedSum '(1 2 3 4 5 6) '(#t #f #f #t #f #t)) ;; 11
(maskedSum '(1 2 3 4 5 6) '(#f #t #f #t #f #f)) ;; 6
(maskedSum '(1 2 3 4 5 6) '(#t #t #t #t #t #t)) ;; 21

;; === shift ===

(define (shift lst n)
  (if (negative? n)
    (append lst (build-list (abs n) (lambda (x) 0)))
    (append (build-list n (lambda (x) 0)) lst)
  )
)

(display "=== shift ===\n")
(shift '(3 5 0 0 2) 3) ;; '(0 0 0 3 5 0 0 2)
(shift '(19 4 50 10 2) -2) ;; '(19 4 50 10 2 0 0)

;; === list2matrix ===

(define (list2matrix lst r c)
  (if (null? lst)
    null
    (if (= (length lst) (* r c))
      (if (> r 1)
        (list (take lst c) (list2matrix (drop lst c) (sub1 r) c))
        (take lst c)
      )
      lst
    )
  )
)

(display "=== list2matrix ===\n")

(list2matrix '(10 20 30 40 50 60) 2 3) ;; '((10 20 30) (40 50 60))
(list2matrix '(10 20 30 40 50 60) 3 2) ;; '((10 20) (30 40) (50 60))
(list2matrix '(10 20 30 40 50 60) 3 3) ;; '(10 20 30 40 50 60)

;; === myFilter ===

(define (myFilter f x)
  (if (null? x)
    x
    (if (f (car x))
      (list* (car x) (myFilter f (cdr x)))
      (myFilter f (cdr x))
    )
  )
)

(display "=== myFilter ===\n")
(myFilter (lambda (x) (> x 2)) '(1 2 0 3 4 1 2 9)) ;; '(3 4 9)
(myFilter (lambda (x) (= x 2)) '(1 2 0 3 4 1 2 9)) ;; '(2 2)
(myFilter (lambda (x) (= (remainder x 2) 0)) '(1 2 0 3 4 1 2 9)) ;; '(2 0 4 2)

;; === swap ===

(define (swap i j lst)
  (append
    (take lst i) ;; Before new
    (list(car (drop lst j))) ;; new
    (take (drop lst (add1 i)) (sub1 (- j i)));;between new and old
    (list(car (drop lst i))) ;; old
    (drop lst (add1 j));; after old
  )
)

(display "=== swap ===\n")
(swap 4 5 '(a b c d e f)) ;; '(a b c d f e)
(swap 1 3 '(10 20 30 40)) ;; '(10 40 30 20)
(swap 0 4 '(a b c d (e) f)) ;; '((e) b c d a f)

;; === evaluate ===

(define (enumerate lst)
  (define (enumarate_x lst n)
    (if (null? lst)
    lst
    (if (null? (cdr lst))
      (list(list (car lst) n))
      (list*  (list (car lst) n) (enumarate_x (cdr lst) (add1 n)))
    )
    )
  )
  (enumarate_x lst 0)
)

(define (evaluate coef x)
  (apply +
    (map
      (lambda (row)
        (* (car row) (expt x (cadr row)))
      )
      (enumerate (reverse coef))
    )
  )
)

(display "=== evaluate ===\n")
(evaluate '() 100) ;; 0
(evaluate '(2 3.1 10 0) 2) ;; 48.4
(evaluate '(10 0) 2) ;; 20
(evaluate '(1 2 3 4 5) 3) ;; 179

;; === ackermann ===

(define (ackermann m n)
  (cond
    [(= m 0)
      (add1 n)
    ]
    [(= n 0)
      (ackermann (sub1 m) 1)
    ]
    [else
      (ackermann (sub1 m) (ackermann  m (sub1 n)))
    ]
  )
)

(display "=== ackermann ===\n")
(ackermann 2 2) ;; 7
(ackermann 2 5) ;; 13
(ackermann 3 1) ;; 13
(ackermann 3 8) ;; 2045

;; === select ===

;; This should not be done! (but it helps)
(define table '(
  ((name "Charles") (age 24))
  ((age 23) (name "Mary") (lastName "Danvers") (gender "female"))
  ((name "Caroline") (lastName "Ortiz") (age 19))
  )
)

(define (select table key)
  (list* key 
    (filter-map
      (lambda (row)
        (let 
          ((x
            (filter-map 
              (lambda (item)
                (and 
                  (equal? (car item) key)
                  (cadr item)
                )
              )
              row
            )
          )) 
          (if (null? x)
            #f
            (car x)
          )
        )
      )
      table
    )
  )  
)

(display "=== select ===\n")
(select table 'age) ;; '(age 24 23 19)
(select table 'phone) ;; '(phone)
(select table 'lastName) ;; '(lastName "Danvers" "Ortiz")