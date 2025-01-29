#lang racket

;; add comment
(define (count1bits N)
  (cond
      [(= N 1) 1] 
      [(odd? N)(+ 1 (count1bits (quotient N 2)))]
      [else (+ 0 (count1bits (quotient N 2)))]
      )
)

;; student tests
(check-equal? (count1bits 1) 1)
(check-equal? (count1bits 2) 1)
(check-equal? (count1bits 3) 2)
(check-equal? (count1bits 5) 2)

;; provided tests
(check-equal? (count1bits 6) 2)
(check-equal? (count1bits 7) 3)
(check-equal? (count1bits 42) 3)
