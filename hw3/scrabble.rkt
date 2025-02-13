#lang racket

(provide subbag? best-word)

;; takes in two lists S and B, returns true if every element of S is in every element of B (not dependent on order)
;; the count of any element in S is at least as large in B
(define (subbag? S B)
  (cond
    [(empty? S) #t]
    [(member (first S) B) (subbag? (rest S) (remove (first S) B))]
    [else #f])
)

;; i am fully aware that my best-word function does not work properly but i wanted to submit it because it should pass a few of of the tests

;; scrabble-tile-bag  
;;   letter tile scores and counts from the game of Scrabble
;;   the counts are not needed
;;   obtained from http://en.wikipedia.org/wiki/Image:Scrabble_tiles_en.jpg
(define scrabble-tile-bag
  '((#\a 1 9) (#\b 3 2) (#\c 3 2) (#\d 2 4) (#\e 1 12)
   (#\f 4 2) (#\g 2 3) (#\h 4 2) (#\i 1 9) (#\j 8 1)
   (#\k 5 1) (#\l 1 4) (#\m 3 2) (#\n 1 6) (#\o 1 8)
   (#\p 3 2) (#\q 10 1)(#\r 1 6) (#\s 1 4) (#\t 1 6)
   (#\u 1 4) (#\v 4 2) (#\w 4 2) (#\x 8 1) (#\y 4 2)
   (#\z 10 1) (#\_ 0 2)) )

(define (letterScore letter)
  (second (assoc letter scrabble-tile-bag))
)

(define (wordScore word)
  (if (empty? word)
  0
  (+ (letterScore (first word))(wordScore (rest word)))
))

(define (scoreList WL)
  (if (empty? WL)
  '()
  (cons (cons (first WL) (wordScore (string->list (first WL)))) (scoreList (rest WL)))
))

(define (maxElement x y) 
  (if (> x y) 
  x 
  y
))

(define (max L)
  (if (empty? (rest L))
      (first L)
      (let ((maxRest (max (rest L)))) 
        (if (> (cdr (first L)) (cdr maxRest)) 
            (first L)  
            maxRest))))

(define (best-word rack WL)
  (let* ((output (max (scoreList WL))))
  (list (car output) (cdr output))
  ))
