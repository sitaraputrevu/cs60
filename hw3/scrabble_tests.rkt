#lang racket

(require rackunit)
(require "scrabble.rkt")

; student tests
(check-true  (subbag? '() '()) )
(check-true  (subbag? '(cherry apple banana) '(apple banana cherry)) )
(check-true  (subbag? '(cherry 2 0 1) '(2 0 1 cherry 8 banana)) )
(check-false  (subbag? '(2 2 2) '(1 2 2 5 6)) )
(check-false  (subbag? '(2 4) '()) )

; provided tests
(check-true  (subbag? '()      '(s p a m s)) )
(check-true  (subbag? '(s s)   '(s p a m s)) )
(check-true  (subbag? '(s m)   '(s p a m s)) )
(check-true  (subbag? '(a p)   '(s p a m s)) )
(check-false (subbag? '(a m a) '(s p a m s)) )
(check-true  (subbag? '(a s)   '(s a))       )

(check-equal? (best-word "academy" '("ace" "ade" "cad" "cay" "day")) 
 '("cay" 8))
(check-equal? (best-word "appler"  '("peal" "peel" "ape" "paper")) 
 '("paper" 9))
(check-equal? (best-word "paler"   '("peal" "peel" "ape" "paper"))
 '("peal" 6))
(check-equal? (best-word "kwyjibo" '("ace" "ade" "cad" "cay" "day"))
 '("" 0))
