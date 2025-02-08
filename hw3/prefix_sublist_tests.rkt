#lang racket

(require rackunit)
; (require "prefix_sublist.rkt")

; student tests

(check-true  (prefix? '() '(1 2 3 4))
(check-true  (prefix? '() '())
(check-true  (prefix? '(1 2) '(1 2 3 4))
(check-false  (prefix? '(3 4) '(1 2 3 4))
(check-false  (prefix? '(2 4) '(1 2 3 4))
(check-false  (prefix? '(1 5) '(1 2 3 4))

(check-true  (sublist? '() '(1 2 3 4))
(check-true  (sublist? '() '())
(check-true  (sublist? '(1 2) '(1 2 3 4))
(check-true  (sublist? '(3 4) '(1 2 3 4))
(check-false  (sublist? '(2 4) '(1 2 3 4))
(check-false  (sublist? '(1 5) '(1 2 3 4))

; provided tests

(check-true  (prefix? '()    '(s p a m)))
(check-true  (prefix? '(s p) '(s p a m)))
(check-false (prefix? '(s m) '(s p a m)))
(check-false (prefix? '(p a) '(s p a m)))

(check-true  (sublist? '()    '(s p a m)))
(check-true  (sublist? '(s p) '(s p a m)))
(check-false (sublist? '(s m) '(s p a m)))
(check-true  (sublist? '(p a) '(s p a m)))
