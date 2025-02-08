#lang racket

(require rackunit)
(require "remove-all.rkt")


; student tests
(check-equal? (remove-all 3 '()) '())
(check-equal? (remove-all 2 '(1 4 5)) '(1 4 5))
(check-equal? (remove-all 2 '(1 2 4 5)) '(1 4 5))
(check-equal? (remove-all 2 '(1 2 (2 4) 5)) '(1 (2 4) 5))
(check-equal? (remove-all "e" '("e" "a" "i" "e" "e" "o")) '("a" "i" "o"))

; provided tests
(check-equal? (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) 
              '("a" "l" "e" "n"))
(check-equal? (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) 
              '(("a" "l" "i") "e" "n"))
(check-equal? (remove-all 0 '(1 0 1 0 1 0))  
              '(1 1 1))

