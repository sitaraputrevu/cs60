#lang racket

(require rackunit)
(require "lotto-winner.rkt")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Testing matches
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; provided tests
(check-equal? (matches '(cat 1)     '())       0)
(check-equal? (matches '(cat 1)     '(2 3 4))  0)
(check-equal? (matches '(cat 1)     '(1))      1)
(check-equal? (matches '(ace 2 3 4) '(3 42 2)) 2)
(check-equal? (matches '(ace 2 3 4) '(8 4 5))  1)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Testing lotto-winner
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; student tests
(check-equal? (lotto-winner
               '( (aanya 2 4 16 33 42)  
                  (bao 3 4 5 6 7) 
                  (cruz 3 15 16 41 42) ) 
               '(9 1 14 32 49)) ; winning tickets
              '()) ; <- output of lotto-winner
(check-equal? (lotto-winner
               '( (aanya 2 4 16 33 42)  
                  (bao 3 4 5 6 7) 
                  (cruz 3 15 16 41 42) ) 
               '(3 4 5 6 7)) ; winning tickets
              '(bao 5)) ; <- output of lotto-winner
(check-equal? (lotto-winner
               '( (aanya 2 4 16 33 42)  
                  (bao 3 4 5 6 7) 
                  (cruz 3 15 16 41 42) ) 
               '(3 4 16 41 0)) ; winning tickets
              '(cruz 3)) ; <- output of lotto-winner

; provided tests
(check-equal? (lotto-winner
               '( (aanya 2 4 16 33 42)  
                  (bao 3 4 5 6 7) 
                  (cruz 3 15 16 41 42) ) 
               '(2 3 15 32 42)) ; winning tickets
              '(cruz 3)) ; <- output of lotto-winner

