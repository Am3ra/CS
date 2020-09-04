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

;; === fibonacci ===

(define (fibonacci n)
	(display "Not yet implemented\n")
)

(display "=== fibonacci ===\n")
(fibonacci 10) ;; 55
(fibonacci 15) ;; 610
(fibonacci 20) ;; 6765

;; === nestedSum ===

(define (nestedSum lst)
	(display "Not yet implemented\n") 
)

(display "=== nestedSum ===\n")
(nestedSum '(10 20 30 40)) ;; 100 
(nestedSum '(15 (5 4 (3 10)) 6 (8))) ;; 51
(nestedSum '(((20 () ()) () 3))) ;; 23

;; === evenNumbers ===

(define (evenNumbers lst)
	(display "Not yet implemented\n")
)

(display "=== evenNumbers ===\n")
(evenNumbers '(10 3 25 32 37 9)) ;; '(10 32) 
(evenNumbers '(15 (5 4 (3 10)) 6 (8))) ;; '((4 (10)) 6 (8))
(evenNumbers '(((20 () ()) () 3))) ;; '(((20 () ()) ()))

;; === nestedReverse ===

(define (nestedReverse lst)
	(display "Not yet implemented\n")
)

(display "=== nestedReverse ===\n")
(nestedReverse '(10 3 25 32 37 9)) ;; '(9 37 32 25 3 10)
(nestedReverse '(15 (5 4 (3 10)) 6 (8))) ;; '((8) 6 ((10 3) 4 5) 15)
(nestedReverse '(((20 () ()) () 3))) ;; '((3 () (() () 20)))

;; === unroll ===

(define (unroll lst)
	(display "Not yet implemented\n") 	
)

(display "=== unroll ===\n")
(unroll '(10 3 25 32 37 9)) ;; '(10 3 25 32 37 9)
(unroll '(15 (5 4 (3 10)) 6 (8))) ;; '(15 5 4 3 10 6 8)
(unroll '(((20 () ()) () 3))) ;; '(20 3)
