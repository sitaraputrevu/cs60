#lang racket

(provide superreverse duperreverse)

(define (superreverse L)
  (if (empty? L)
    '()
    (cons (reverse (first L)) (superreverse (rest L)))
))

(define (duperreverse L)
  (cond
    [(empty? L) '()]
    [(list? (first L)) (cons (duperreverse (rest L)) (duperreverse (first L)))]
    [else (cons (duperreverse (rest L)) (first L))]
))
