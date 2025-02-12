#lang racket

(require rackunit)
(require "superduper.rkt")

; student tests
(check-equal? (superreverse '())
                '())
(check-equal? (superreverse '((cherry banana apple) (mango strawberry kiwi)))
                  '((apple banana cherry) (kiwi strawberry mango)))
(check-equal? (duperreverse '())
                  '())
(check-equal? (duperreverse '((cherry banana apple) (mango strawberry kiwi)))
                  '((kiwi strawberry mango) (apple banana cherry)))

; provided tests
(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
                            '( (3 2 1) (9 (7 8) 6 5 4) ) )

(check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
                            '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) )

(check-equal? (duperreverse '( (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
                            '( ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ))

(check-equal? (duperreverse '( (1 2 3) (4 5 6 (7 8) 9) ))
                            '( (9 (8 7) 6 5 4) (3 2 1) ))
