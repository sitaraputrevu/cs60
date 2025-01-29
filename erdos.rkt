#lang racket

;; Two functions will be treated as publicly accessible
;;   (so that we can test them)
(provide erdos erdos-count)


;; erdos: the "erdos" function
;;   input: a positive integer, N
;;   output: 3N+1, if N is odd
;;           N/2, if N is even
(define (erdos N)
  (if (= (remainder N 2) 0)
    (quotient N 2)
    (+ 1 (* 3 N))
  )
)

;; takes an input of a positive integer N, and then runs "erdos" on it, then on the result, and so on
;; when the result is 1, returns the number of times that "erdos" was run
(define (erdos-count N)
  (if (= N 1)
       0
    (+ 1 (erdos-count (erdos N)))
  )
)
