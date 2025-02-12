#lang racket

(provide superreverse duperreverse)

(define (superreverse L)
  (if (empty? L)
    '()
    (cons (reverse (first L)) (superreverse (rest L)))
))

(define (duperreverse L)

)
