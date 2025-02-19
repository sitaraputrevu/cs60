#lang racket

(provide matches)
(provide lotto-winner)


;; matches: finds the number of matches between ticket and winning numbers
;;   inputs: tickets - lotto ticket, list of numbers
;;             expected format:  '(name # # ... #)
;;           winning-numbers - winning numbers, list of numbers
;;             expected format:  '(# # .. #)
;;   output: the number elements that match between tickets and winning-numbers
(define (matches ticket winning-numbers)
  (length 
   (filter (lambda (potential-match) 
             (member potential-match winning-numbers))
           ticket)))


;; lotto-winner: finds the name and number of the winning ticket
;;   inputs: list-of-tickets - list of lotto tickets, list of lists of numbers
;;             expected format:  '((name1 # # ... #) ... (nameN # # ... #)) 
;;           winning-numbers - winning numbers, list of numbers
;;             expected format:  '(# # .. #)
;;   output: the name and number of matching tickets from the ticket 
;;           with the most matches in winning-numbers
(define (lotto-winner list-of-tickets winning-numbers)
  (let* ([list-matches (map (lambda (x) (matches x winning-numbers)) list-of-tickets)]
        [list-matches-sorted (sort list-matches >)]
        [highest-match (first list-matches-sorted)]
        [list-matches-names (map (lambda (x) (list (matches x winning-numbers) (first x))) list-of-tickets)])
    (if (= highest-match 0)
      '()
      (reverse (assoc highest-match list-matches-names))
)))


