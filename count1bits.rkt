#lang racket

(provide count1bits)

;; takes an input N and returns the number of times the bit 1 appears in the binary representation of N
;; adds one for every odd number, then divides every number by two (and rounds down)
;; repeats until the only number left is 1
(define (count1bits N)
  (cond
      [(= N 1) 1] 
      [(= N 0) 0] 
      [(odd? N)(+ 1 (count1bits (quotient N 2)))]
      [else (count1bits (quotient N 2))]
      )
)
