#lang racket

(provide enumerate)

;; add comment
(define (indexList num L)
  (list num (first L)))

;; add comment
(define (enumerate L)
  (if (empty? L)
  '()
  (cons (indexList 0 L) (enumerate (rest L))))
)
