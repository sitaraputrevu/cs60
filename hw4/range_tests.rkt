#lang racket

(require rackunit)
(require "range.rkt")

; student definitions and test cases
(define value5to15? (make-range-predicate 4 16))
(check-equal? (value5to15? 0)  false)
(check-equal? (value5to15? 4)  false)
(check-equal? (value5to15? 16)  false)
(check-equal? (value5to15? 100)  false)
(check-equal? (value5to15? 5)  true)
(check-equal? (value5to15? 15)  true)
(check-equal? (value5to15? 10)  true)

; provided definitions calling make-range-predicate
(define value1to3?   (make-range-predicate 0 4))
(define value1to100? (make-range-predicate 0 101))


; provided test cases for value1to3? and value1to100?
(check-equal? (value1to3? 0)  false)
(check-equal? (value1to3? 1)  true)
(check-equal? (value1to3? 2)  true)
(check-equal? (value1to3? 3)  true)
(check-equal? (value1to3? 4)  false)
(check-equal? (value1to3? 42) false)

(check-equal? (value1to100? 0)   false)
(check-equal? (value1to100? 1)   true)
(check-equal? (value1to100? 20)  true)
(check-equal? (value1to100? 42)  true)
(check-equal? (value1to100? 100) true)
(check-equal? (value1to100? 101) false)
(check-equal? (value1to100? 999) false)

