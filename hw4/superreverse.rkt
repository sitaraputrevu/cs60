#lang racket

(provide superreverse)


;; takes in a list L and reverses each list within it (without reversing their placement in L)
(define (superreverse L)
  (map reverse L)
)

