#!/usr/bin/racket
#lang racket

(define (sumList lst)
    (if (null? lst)
        0
        (if (number? (car list))
            (+ (car list) (sumList(cdr lst)))
            (sumList (sumList(cdr lst)))
        )
    )
)

(define (rev lst)
    (if (null? lst)
        null
        (append (rev (cdr lst))(list (car lst)))
    )
)

(rev '(a b c d e))

(define (palindrome? lst)
    (equal? lst (reverse lst))
)



(define (idx lst index)
    (if (and (>= index 0) (< index (length lst)))
        (if (= index 0)
            (car lst)
            (idx (cdr lst)(- index 1))
        )
        null
    )
)

(idx '(a b c d e) 2)
(idx '(a b c d e) 1)

(define (oddPos lst)
    (if (or (null? lst)(null? (cdr lst)))
        null
        (list* (cadr lst) (oddPos (cddr lst)))
    )
)
(oddPos '(a b c d e f))
