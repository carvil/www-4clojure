(ns www-4clojure.core-test
  (:use midje.sweet
        www-4clojure.core))

(fact "Problem 19 - Last element"
  (= (last-element [1 2 3 4 5]) 5) => true
  (= (last-element '(5 4 3)) 3) => true
  (= (last-element ["b" "c" "d"]) "d") => true)

(fact "Problem 20 - Penultimate Element"
  (= (penultimate-element (list 1 2 3 4 5)) 4) => true
  (= (penultimate-element ["a" "b" "c"]) "b") => true
  (= (penultimate-element [[1 2] [3 4]]) [1 2]) => true)

(fact "Problem 21 - Nth Element"
  (= (nth-element '(4 5 6 7) 2) 6) => true
  (= (nth-element [:a :b :c] 0) :a) => true
  (= (nth-element [1 2 3 4] 1) 2) => true
  (= (nth-element '([1 2] [3 4] [5 6]) 2) [5 6]) => true)

(fact "Problem 22 - Count a Sequence"
  (= (count-a-sequence '(1 2 3 3 1)) 5) => true
  (= (count-a-sequence "Hello World") 11) => true
  (= (count-a-sequence [[1 2] [3 4] [5 6]]) 3) => true
  (= (count-a-sequence '(13)) 1) => true
  (= (count-a-sequence '(:a :b :c)) 3) => true)
