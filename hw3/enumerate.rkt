#lang racket

(provide indexList enumerate)

;; takes in an input of a number (index) and a list and increments the index, matching each index to its element
(define (indexList num L)
  (if (empty? L)
  '()
  (cons (list num (first L)) (indexList (+ 1 num) (rest L)))))

;; calls indexList with the initial index of 0
(define (enumerate L)
  (indexList 0 L)
)
