#lang racket

(provide indivisible)

;; takes in a positive integer e and returns the elements of the list L that are not divisible by E
(define (indivisible e L)
  (filter (lambda (num) (not (= (modulo num e) 0))) L)
)
