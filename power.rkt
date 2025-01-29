#lang racket

(define (power base pow)
)

(define (fast-power base pow)
)

(provide power)
(provide fast-power)

;; provided tests
(check-equal? (power 2 10) 1024)
(check-equal? (power 42 10) 17080198121677824)
(check-equal? (fast-power 2 10) 1024)
(check-equal? (fast-power 42 10) 17080198121677824)

;; student tests
(check-equal? (power 3 0) 1)
(check-equal? (power 5 2) 25)
(check-equal? (power 1 3) 1)
(check-equal? (power 2 3) 8)
(check-equal? (fast-power 3 0) 1)
(check-equal? (fast-power 5 2) 25)
(check-equal? (fast-power 1 3) 1)
(check-equal? (fast-power 2 3) 8)

