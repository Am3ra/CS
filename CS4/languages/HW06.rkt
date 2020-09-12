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

;; === sum ===

(define (sum matrix)
	(apply + (map  (lambda (row)
		(apply + row)	
		)
		matrix
	))
)

(display "=== sum ===\n")
;;; (sum '((1 2 3))) ;; 45
(sum '((1 2 3) (4 5 6) (7 8 9))) ;; 45
(sum '((1 2) (30 40) (5 6) (70 80))) ;; 234
(sum '((8 9 5 6 7) (3 4 5 4 2))) ;; 53

;; === complete? ===

(define (complete? graph)
	(let ([len (length graph)])
		(andmap (lambda (row)
			(= (length row) len)
		) graph)
	)
)

(display "=== complete? ===\n")
(complete? '((a b c) (b a c) (c a b) (d e) (e d))) ;; #f
(complete? '((a b) (b a))) ;; #t
(complete? '( (a c) (b a) (c a))) ;; #f

;; === msort ===
(define (mlists x y)
	(cond
		[(null? x) y]
		[(null? y) x]
		[(> (car x) (car y))
			(cons (car y) (mlists (cdr y) x))
		]
		[else
			(cons (car x) (mlists (cdr x) y))
		]
	)

)

(define (msort lst)
	
	(cond
		[(null? lst) lst]
		[(= (length lst) 1) lst]
		[(= (length lst) 2) 
			(mlists (list (car lst)) (cdr lst))
		]
		[else
			 (let ([xs (ceiling (/ (length lst) 2))])
       			(mlists (msort (take lst xs))
				(msort (drop lst xs))))
		]
	)
)

(display "=== msort ===\n")
(msort '()) ;; '()
(msort '(1)) ;; '(1)
(msort '(1 2)) ;; '(1)
(msort '(10 35 8 2.6 4.7 12)) ;; '(2.6 4.7 8 10 12 35)
(msort '(1 4 7 9 3 4 8 10)) ;; '(1 3 4 4 7 8 9 10)

;; === sold-units ===

;; This should not be done! (but it helps)
(define sales 
  '(
    (105 (10 3) (4 2) (9 3))
    (106 (6 4) (8 1) (4 6))
    (107 (9 7) (12 1) (14 1) (10 4))
    (108 (4 1))
    (109 (7 21) (10 4) (14 6) (5 3))
  )
)

(define (sold-units id sales)
  	(sum (map
		(lambda (row)
			(map
				(lambda (item)
					(if (= (car item) id)
						(cadr item)
						0
					)
				)
				(cdr row)
			)
		)
		sales  
	))
)

(display "=== sold-units ===\n")
(sold-units 2 sales) ;; 0
(sold-units 9 sales) ;; 10
(sold-units 10 sales) ;; 11
(sold-units 14 sales) ;; 7

;; === insert ===

(define (insert x tree)
	(cond 
		[(null? tree)
			(list x null null)
		]
		[(< x (car tree))
			(list (car tree) (insert x (cadr tree)) (caddr tree))
		]
		[else
			(list (car tree) (cadr tree) (insert x (caddr tree)))
		]
	)
)

(display "=== insert ===\n")
(insert 1 '()) ;; '(1 () ())
(insert 3 '(1 () (5 () ()))) ;; '(1 () (5 (3 () ()) ()))
(insert 0 '(1 () (5 (3 () ()) (6 () ())))) ;; '(1 (0 () ()) (5 (3 () ()) (6 () ())))

;; == set ===

(define (set lst)
  	(remove-duplicates
		(filter
			(lambda (element)
				(number? element)
			)
			lst
		)
	)
)

(display "=== set ===\n")
(set '(1 2 3 2 4 a (1 2) 5 2 3)) ;; '(1 4 5 2 3)
(set '(a b 3 4)) ;; '(3 4)
(set '(10 (a b 3) 4 (8) c d (a b 3) d c 11)) ;; '(10 4 11)

(define (union x y)
  	(set (append x y))
)

(display "=== union ===\n")
(union '(1 2 3 4) '(3 4 5 6)) ;; '(1 2 3 4 5 6)
(union '(10 2 8 4) '()) ;; '(10 2 8 4)
(union '(2 a 8 4) '(b c d)) ;; '(2 8 4)

(define (intersection x y)
	(set
		(filter
			(lambda (item)
				(member item x)
			)
			y
		)
	)
)

(display "=== intersection ===\n")
(intersection '(1 2 3 4) '(3 4 5 6)) ;; '(3 4)
(intersection '(10 2 8 4) '()) ;; '()
(intersection '(2 a 8 4) '(b c 8 d)) ;; '(8)
