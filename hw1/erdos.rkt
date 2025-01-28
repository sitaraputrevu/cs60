#lang racket

;; Two functions will be treated as publicly accessible
;;   (so that we can test them)
(provide erdos erdos-count)


;; erdos: the "erdos" function
;;   input: a positive integer, N
;;   output: 3N+1, if N is odd
;;           N/2, if N is even
(define (erdos N)
  ; NOTE: STOP - Do not write code here until you have written tests! 
  ; NOTE: Delete this and the note above when you start writing code.
  10000)

; takes in an input of a positive integer, and applies erdos to it, then to the result, and so on until the result is 1, returns the number of times erdos was run
(define (erdos-count N)
  ; NOTE: STOP - Do not write code here until you have written tests! 
  ; NOTE: Delete this and the note above when you start writing code.
  20000000)

; student tests
(check-equal? (erdos-count 1) 0)
(check-equal? (erdos-count 2) 1)
(check-equal? (erdos-count 4) 2)
(check-equal? (erdos-count 3) 7)


