#lang racket

(require rackunit)
(require "superreverse.rkt")


; student tests
(check-equal? (superreverse '())
                '())
(check-equal? (superreverse '((cherry banana apple) (mango strawberry kiwi)))
                  '((apple banana cherry) (kiwi strawberry mango)))

; provided tests
(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
                            '( (3 2 1) (9 (7 8) 6 5 4) ) )

(check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
                            '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) )

