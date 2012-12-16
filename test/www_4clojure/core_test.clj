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

(fact "Problem 24 - Sum It All Up"
  (= (sum-it-all-up [1 2 3]) 6) => true
  (= (sum-it-all-up (list 0 -2 5 5)) 8) => true
  (= (sum-it-all-up #{4 2 1}) 7) => true
  (= (sum-it-all-up '(0 0 -1)) -1) => true
  (= (sum-it-all-up '(1 10 3)) 14) => true)

(fact "Problem 25 - Find The Odd Numbers"
  (= (find-the-odds #{1 2 3 4 5}) '(1 3 5)) => true
  (= (find-the-odds [4 2 1 6]) '(1)) => true
  (= (find-the-odds [2 2 4 6]) '()) => true
  (= (find-the-odds [1 1 1 3]) '(1 1 1 3)) => true)

(fact "Problem 23 - Reverse a sequence"
  (= (reverse-a-sequence [1 2 3 4 5]) [5 4 3 2 1]) => true
  (= (reverse-a-sequence (sorted-set 5 7 2 7)) '(7 5 2)) => true
  (= (reverse-a-sequence [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) => true)

(fact "Problem 27 - Palindrome Detector"
  (false? (palindrome-detector '(1 2 3 4 5))) => true
  (true? (palindrome-detector "racecar")) => true
  (true? (palindrome-detector [:foo :bar :foo])) => true
  (true? (palindrome-detector '(1 1 3 3 1 1))) => true
  (false? (palindrome-detector '(:a :b :c))) => true)

(fact "Problem 26 - Fibonacci Sequence"
  (= (fibonacci-sequence 3) '(1 1 2)) => true
  (= (fibonacci-sequence 6) '(1 1 2 3 5 8)) => true
  (= (fibonacci-sequence 8) '(1 1 2 3 5 8 13 21)) => true)

(fact "Problem 28 - Flatten a Sequence"
  (= (flatten-seq '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) => true
  (= (flatten-seq ["a" ["b"] "c"]) '("a" "b" "c")) => true
  (= (flatten-seq '((((:a))))) '(:a)) => true)

(fact "Problem 29 - Get the Caps"
  (= (get-the-caps "HeLlO, WoRlD!") "HLOWRD") => true
  (empty? (get-the-caps "nothing")) => true
  (= (get-the-caps "$#A(*&987Zf") "AZ") => true)

(fact "Problem 30 - Compress a Sequence"
  (= (apply str (compress-seq "Leeeeeerrroyyy")) "Leroy") => true
  (= (compress-seq [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) => true
  (= (compress-seq [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) => true)

(fact "Problem 31 - Pack a Sequence"
  (= (pack-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))) => true
  (= (pack-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))) => true
  (= (pack-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))) => true)

(fact "Problem 32 - Duplicate a Sequence"
  (= (dup-seq [1 2 3]) '(1 1 2 2 3 3)) => true
  (= (dup-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)) => true
  (= (dup-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) => true
  (= (dup-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) => true)

(fact "Problem 33 - Replicate a Sequence"
  (= (replicate-seq [1 2 3] 2) '(1 1 2 2 3 3)) => true
  (= (replicate-seq [:a :b] 4) '(:a :a :a :a :b :b :b :b)) => true
  (= (replicate-seq [4 5 6] 1) '(4 5 6)) => true
  (= (replicate-seq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) => true
  (= (replicate-seq [44 33] 2) [44 44 33 33]) => true)

(fact "Problem 34 - Implement range"
  (= (my-range 1 4) '(1 2 3)) => true
  (= (my-range -2 2) '(-2 -1 0 1)) => true
  (= (my-range 5 8) '(5 6 7)) => true)

(fact "Problem 38 - Maximum value"
  (= (maximum-val 1 8 3 4) 8) => true
  (= (maximum-val 30 20) 30) => true
  (= (maximum-val 45 67 11) 67) => true)

(fact "Problem 39 - Interleave two sequences"
  (= (interleave-seqs [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)) => true
  (= (interleave-seqs [1 2] [3 4 5 6]) '(1 3 2 4)) => true
  (= (interleave-seqs [1 2 3 4] [5]) [1 5]) => true
  (= (interleave-seqs [30 20] [25 15]) [30 25 20 15]) => true)

(fact "Problem 40 - Interpose a sequence"
  (= (interpose-seq 0 [1 2 3]) [1 0 2 0 3]) => true
  (= (apply str (interpose-seq ", " ["one" "two" "three"])) "one, two, three") => true
  (= (interpose-seq :z [:a :b :c :d]) [:a :z :b :z :c :z :d]) => true)

(fact "Problem 41 - Drop every nth element"
  (= (drop-every-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]) => true
  (= (drop-every-nth [:a :b :c :d :e :f] 2) [:a :c :e]) => true
  (= (drop-every-nth [1 2 3 4 5 6] 4) [1 2 3 5 6]) => true)

(fact "Problem 42 - Factorial"
  (= (factorial 1) 1) => true
  (= (factorial 3) 6) => true
  (= (factorial 5) 120) => true
  (= (factorial 8) 40320) => true)

(fact "Problem 43 - Reverse interleave"
  (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))) => true
  (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))) => true
  (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))) => true)

(fact "Problem 44 - Rotate Sequence"
  (= (rotate-sequence 2 [1 2 3 4 5]) '(3 4 5 1 2)) => true
  (= (rotate-sequence -2 [1 2 3 4 5]) '(4 5 1 2 3)) => true
  (= (rotate-sequence 6 [1 2 3 4 5]) '(2 3 4 5 1)) => true
  (= (rotate-sequence 1 '(:a :b :c)) '(:b :c :a)) => true
  (= (rotate-sequence -4 '(:a :b :c)) '(:c :a :b)) => true)

(fact "Problem 46 - Flipping out"
  (= 3 ((flipping-out nth) 2 [1 2 3 4 5])) => true
  (= true ((flipping-out >) 7 8)) => true
  (= 4 ((flipping-out quot) 2 8)) => true
  (= [1 2 3] ((flipping-out take) [1 2 3 4 5] 3)) => true)

(fact "Problem 49 - Split a Sequence"
  (= (split-a-sequence 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]) => true
  (= (split-a-sequence 1 [:a :b :c :d]) [[:a] [:b :c :d]]) => true
  (= (split-a-sequence 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]) => true)
