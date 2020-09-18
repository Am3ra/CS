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

;; === exam.stdev ===

(define (mean lst)
	(/ (apply + lst) (length lst))
)

(define (exam.stdev lst)
	(let ((x (mean lst)))
		(sqrt(/(apply + (map (lambda (item)
			(expt (- item  x) 2)
		)
		lst)) (sub1 (length lst))))
	)
)

(display "=== exam.stdev ===\n")
(exam.stdev '(1 2 3 4 5 6)) ;; 1.8708286933869707
(exam.stdev '(300 250 58 47 125 36)) ;; 113.15299377391656
(exam.stdev '(1 2)) ;; 0.7071067811865476

;; === exam.toBinary ===

(define (exam.toBinary x)
	(display "Not yet implemented\n")
)

(display "=== exam.toBinary ===\n")
(exam.toBinary 0) ;; '(0)
(exam.toBinary 1) ;; '(1)
(exam.toBinary 3) ;; '(1 1)
(exam.toBinary 7) ;; '(1 1 1)
(exam.toBinary 32) ;; '(1 0 0 0 0 0)
(exam.toBinary 847) ;; '(1 1 0 1 0 0 1 1 1 1)

;; === exam.numberToList ===

(define (exam.numberToList x)
	(display "Not yet implemented\n")
)

(display "=== exam.numberToList ===\n")
(exam.numberToList 100) ;; '(1 0 0)
(exam.numberToList 17395) ;; '(1 7 3 9 5)
(exam.numberToList 0) ;; '(0)

;; === exam.differences ===

(define (exam.differences lst)
	(if (null? lst)
		lst
		(map 
			(lambda (x y)
				(abs(- x y))
			)
			lst (append (cdr lst) (list (car lst))))
	)
)

(display "=== exam.differences ===\n")
(exam.differences '(1 2 4 8 20)) ;; '(1 2 4 12 19)
(exam.differences '(5 9 13 27 100 91 4)) ;; '(4 4 14 73 9 87 1)
(exam.differences '(99)) ;; '(0)
(exam.differences '()) ;; '()

;; === exam.rotate ===

(define (exam.rotate matrix)
	(display "Not yet implemented\n")
)

(display "=== exam.rotate ===\n")
(exam.rotate '((1 2 3) (4 5 6) (7 8 9))) ;; '((7 4 1) (8 5 2) (9 6 3))
(exam.rotate '((1 2 3) (4 5 6) (7 8 9) (10 11 12))) ;; '((10 7 4 1) (11 8 5 2) (12 9 6 3))
(exam.rotate '((1 2) (3 4) (5 6) (7 8) (9 10))) ;; '((9 7 5 3 1) (10 8 6 4 2))
(exam.rotate '((1 2 3 4 5) (6 7 8 9 10))) ;; '((6 1) (7 2) (8 3) (9 4) (10 5))

;; === exam.scan ===

(define (exam.scan lst)
	(define (state1 lst)
		(if (null? lst)
			#f
			(if (or (= (car lst) 0) (= (car lst) 1))
				(state1 (cdr lst))
				(= (car lst))
			)
		)
	)
	(if (null? lst)
		#f
		(if (= (car lst) 1)
			(state1 (cdr lst))
			#f
		)
	)

)

(display "=== exam.scan ===\n")
(exam.scan '(0 1 1 1 1 1 2)) ;; #t
(exam.scan '(1 0 0 0 0 0 0 2)) ;; #f
(exam.scan '(1 0 0)) ;; #f
(exam.scan '(1 1 1 1 0 1 1 1 0 1 1 0 2)) ;; #f
(exam.scan '(1 1 2)) ;; #t
(exam.scan '(0 1 1 2)) ;; #t

;; === exam.select ===

;; This should not be done! (but it helps)
(define grades 
	'(
		("id" "g1" "g2" "g3")
	 	(796623 62 84 91)
	 	(782544 81 89 77)
	 	(790256 59 62 63)
	 	(799610 75 68 82)
	 	(791313 85 56 92)
	 	(786621 98 97 92)
	 	(809706 91 72 80)
	 )
)

(define (exam.select table cols)
	(let ((x (map 
			(lambda (column)
				(index-of (car table) column)
			)
		cols))) ;;; Define x as columns to get
		
		(map
			(lambda (row)
				(map
					(lambda (col)
						(list-ref row col)
					)
				x)
			)
		table)	
		
		)
)

(display "=== exam.select ===\n")
(exam.select grades '("g1" "g2")) ;; '(("g1" "g2") (62 84) (81 89) (59 62) (75 68) (85 56) (98 97) (91 72))
(exam.select grades '("id")) ;; '(("id") (796623) (782544) (790256) (799610) (791313) (786621) (809706))

;; === exam.insert ===

;; This should not be done! (but it helps)
(define patients '((name height) ("John Wick" 182) ("Ellen Ripley" 173) ("Beatrix Kiddo" 175)))

(define (exam.insert table col index)
	(display "Not yet implemented\n")
)

(display "=== exam.insert ===\n")
(exam.insert patients '(weight 92 73 75) 0) ;; '((weight name height) (92 "John Wick" 182) (73 "Ellen Ripley" 173) (75 "Beatrix Kiddo" 175))
(exam.insert patients '(weight 92 73 75) 1) ;; '((name weight height) ("John Wick" 92 182) ("Ellen Ripley" 73 173) ("Beatrix Kiddo" 75 175))
(exam.insert patients '(weight 92 73 75) 5) ;; '((name height weight) ("John Wick" 182 92) ("Ellen Ripley" 173 73) ("Beatrix Kiddo" 175 75))

