#lang racket

(provide subbag? best-word)

(define (subbag? S B)
  (cond
    [(empty? S) #t]
    [(member (first S) B) (subbag? (rest S) (remove (first S) B))]
    [else #f])
)

(define (best-word rack WL)
)
