#lang racket

(provide prefix? sublist?)

;; takes in two lists P and L, returns true if P is identical to the initial elements in L
(define (prefix? P L)
  (cond
    [(empty? P) #t] ; base case (empty list is a prefix of any list)
    [(empty? L) #f] ; if L is empty and P is not, P is not a prefix of L
    [(= (first P) (first L)) (prefix? (rest P) (rest L))]
    [#f]
))

;; takes in two lists S and L, returns true if S is identical to some set of consecutive elements in L 
(define (sublist? S L)
  (cond
    [(empty? S) #t] ; base case (empty list is a sublist of any list)
    [(empty? L) #f] ; if L is empty and S is not, S is not a sublist of L
    [(prefix? S L) #t] 
    [else (sublist? (rest S) (rest L))]
))
