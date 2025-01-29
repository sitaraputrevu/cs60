#lang racket

;; takes inputs of a base and the power to raise it to
;; multiplies the base by the base to the previous power
;; when the power is 0, outputs 1
(define (power base pow)
  (if (= pow 0)
    1
    (* base (power base (- pow 1)))
   )
)

;; same as the power function, except if the power is even, finds the base to half the power, and squares that
(define (fast-power base pow)
  (let
      ([a (power base (quotient pow 2))])    
  (cond
    [(= pow 0) 1]
    [(odd? pow) (* base (power base (- pow 1)))]
    [else (* a a)]
   ))
)

(provide power)
(provide fast-power)

