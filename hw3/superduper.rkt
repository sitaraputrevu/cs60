#lang racket

(provide superreverse duperreverse)

;; takes in a list of lists L and returns each top level list reversed
(define (superreverse L)
  (if (empty? L)
    '()
    (cons (reverse (first L)) (superreverse (rest L)))
))

;; takes in a list L and returns each list (top level and every other level) reversed
(define (duperreverse L)
  (cond
    [(empty? L) '()]
    [(list? (first L)) (append (duperreverse (rest L)) (list (duperreverse (first L))))]
    [else (append (duperreverse (rest L)) (list (first L)))]
))
