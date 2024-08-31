; Do not turn this file in! It is just to store hints! 
#lang racket

#|
hints:
(0) run and read over the code below - WHY is it producing '(aarya bao cruz) ?
(1) change (first x) to (second x) - what will it produce?
(2) change (second x) to (list (first x)) - again, what will happen?
(3) change (list (first x)) to (list (first x) 42) - again, predict...
(4) change that 42 to be the *correct* score (use matches!)
(5) you need to sort the result! I suggest another line in the let*:
    [S    (sort L (lambda (x1 x2) (something)))]
    What does something have to be? You want a function that returns #t
    when the left-hand element should be earlier in the sorted list.
(6) You are nearly done! What's left?
|#

;; lotto-help: to be determined as you modify the code...
;;  inputs:  a "list of tickets", LT
;;           a list of winning numbers, W
;;  outputs: not yet determined! just for building intuition...
(define (lotto-help LT W)
  (let* (
         [P  (map (lambda (x) (first x)) LT)]
         )
    P    ;; this is the output, for now...
    ))


;; some data
(define Tix '( (aarya 2 4 16 33 42)
               (bao 3 4 5 6 7)
               (cruz 3 15 16 41 42) ))
(define Win '(2 3 15 32 42))

;; Here, we are testing lotto-help by simply _printing_ the result
;; as currently written. This will run lotto-help and return P.
;; The output should be '(alice bob cdrthecat).
(lotto-help Tix Win)

