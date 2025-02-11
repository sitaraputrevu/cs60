#lang racket

(provide enumerate)

;; add comment
(define (indexList num L)
  (if (empty? L)
  '()
  (cons (list num (first L)) (indexList (+ 1 num) (rest L)))))

;; add comment
(define (enumerate L)
  (indexList 0 L)
)
