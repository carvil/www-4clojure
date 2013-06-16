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

(fact "Problem 134 - A nil key"
  (true?  (a-nil-key :a {:a nil :b 2})) => true
  (false? (a-nil-key :b {:a nil :b 2})) => true
  (false? (a-nil-key :c {:a nil :b 2})) => true)

(fact "Problem 156 - Map defaults"
  (= (map-defaults 0 [:a :b :c]) {:a 0 :b 0 :c 0}) => true
  (= (map-defaults "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}) => true
  (= (map-defaults [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}) => true)

(fact "Problem 166 - Comparisons"
  (= :gt (derive-comparison < 5 1)) => true
  (= :eq (derive-comparison (fn [x y] (< (count x) (count y))) "pear" "plum")) => true
  (= :lt (derive-comparison (fn [x y] (< (mod x 5) (mod y 5))) 21 3)) => true
  (= :gt (derive-comparison > 0 2)))

(fact "Problem 61 - Map construction"
  (= (map-cons [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}) => true
  (= (map-cons [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}) => true
  (= (map-cons [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}) => true)

(fact "Problem 66 - Greatest Common Divisor"
  (= (gcd 2 4) 2) => true
  (= (gcd 10 5) 5) => true
  (= (gcd 5 7) 1) => true
  (= (gcd 1023 858) 33) => true)

(fact "Problem 81 - Set intersection"
  (= (my-intersection #{0 1 2 3} #{2 3 4 5}) #{2 3}) => true
  (= (my-intersection #{0 1 2} #{3 4 5}) #{}) => true
  (= (my-intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) => true)

(fact "Problem 62 - Re-implement Iterate"
  (= (take 5 (infinite-seq #(* 2 %) 1)) [1 2 4 8 16]) => true
  (= (take 100 (infinite-seq inc 0)) (take 100 (range))) => true
  (= (take 9 (infinite-seq #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))) => true)

(fact "Problem 107 - simple closure"
  (= 256 ((simple-closure 2) 16),
         ((simple-closure 8) 2)) => true
  (= [1 8 27 64] (map (simple-closure 3) [1 2 3 4])) => true
  (= [1 2 4 8 16] (map #((simple-closure %) 2) [0 1 2 3 4])) => true)

(fact "Problem 99 - product digits"
  (= (product-digits 1 1) [1]) => true
  (= (product-digits 99 9) [8 9 1]) => true
  (= (product-digits 999 99) [9 8 9 0 1]) => true)

(fact "Problem 122 - read a binary number"
  (= 0     (read-bin "0")) => true
  (= 7     (read-bin "111")) => true
  (= 8     (read-bin "1000")) => true
  (= 9     (read-bin "1001")) => true
  (= 255   (read-bin "11111111")) => true
  (= 1365  (read-bin "10101010101")) => true
  (= 65535 (read-bin "1111111111111111")) => true)

(fact "Problem 143 - dot product"
  (= 0 (dot-product [0 1 0] [1 0 0])) => true
  (= 3 (dot-product [1 1 1] [1 1 1])) => true
  (= 32 (dot-product [1 2 3] [4 5 6])) => true
  (= 256 (dot-product [2 5 6] [100 10 1])) => true)

(fact "Problem 135 - infix calculator"
  (= 7  (infix 2 + 5)) => true
  (= 42 (infix 38 + 48 - 2 / 2)) => true
  (= 8  (infix 10 / 2 - 1 * 2)) => true
  (= 72 (infix 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)) => true)

(fact "Problem 118 - Re-implement map"
  (= [3 4 5 6 7] (my-map inc [2 3 4 5 6])) => true
  (= (repeat 10 nil) (my-map (fn [_] nil) (range 10))) => true
  (= [1000000 1000001]
   (->> (my-map inc (range))
        (drop (dec 1000000))
        (take 2))) => true)

(fact "Problem 157 - Indexing sequences"
  (= (indexing-seq [:a :b :c]) [[:a 0] [:b 1] [:c 2]]) => true
  (= (indexing-seq [0 1 3]) '((0 0) (1 1) (3 2))) => true
  (= (indexing-seq [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]) => true)

(fact "Problem 120 - Sum of square of digits"
  (= 8 (sum-sq-digits (range 10))) => true
  (= 19 (sum-sq-digits (range 30))) => true
  (= 50 (sum-sq-digits (range 100))) => true
  (= 50 (sum-sq-digits (range 1000))) => true)

(fact "Problem 83 - a half truth"
  (= false (half-truth false false)) => true
  (= true (half-truth true false)) => true
  (= false (half-truth true)) => true
  (= true (half-truth false true false)) => true
  (= false (half-truth true true true)) => true
  (= true (half-truth true true true false)) => true)

(fact "Problem 88 - symmetric difference"
  (= (symmetric-diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}) => true
  (= (symmetric-diff #{:a :b :c} #{}) #{:a :b :c}) => true
  (= (symmetric-diff #{} #{4 5 6}) #{4 5 6}) => true
  (= (symmetric-diff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}) => true)

(fact "Problem 100 - LCM"
  (==  (lcm 2 3 6)) => true
  (==  (lcm 5 3 7 105)) => true
  (==  (lcm 1/3 2/5 2)) => true
  (==  (lcm 3/4 1/6 3/2)) => true
  (==  (lcm 7 5/7 2 3/5 210)) => true)

(fact "Problem 63 - Group a sequence"
  (= (my-group-by #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}) => true
  (= (my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}) => true
  (= (my-group-by count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}) => true)

(fact "Problem 50 - split by type"
  (= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}) => true
  (= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}) => true
  (= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}) => true)

(fact "Problem 55 - count occurrences"
  (= (count-occur [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}) => true
  (= (count-occur [:b :a :b :a :b]) {:a 2, :b 3}) => true
  (= (count-occur '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}) => true)

(fact "Problem 153 - Pairwise Disjoint Sets"
  (= (pairwise-disjoint-sets #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true) => true
  (= (pairwise-disjoint-sets #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false) => true
  (= (pairwise-disjoint-sets #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true) => true
  (= (pairwise-disjoint-sets #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true) => true
  (= (pairwise-disjoint-sets #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false) => true
  (= (pairwise-disjoint-sets #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false) => true
  (= (pairwise-disjoint-sets #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true) => true
  (= (pairwise-disjoint-sets #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false) => true)

(fact "Problem 90 - cartesian product"
  (= (cartesian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}) => true
  (= (cartesian-product #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}) => true
  (= 300 (count (cartesian-product (into #{} (range 10))
                  (into #{} (range 30))))) => true)

(fact "Problem 102 - camel case"
  (= (camel-case "something") "something") => true
  (= (camel-case "multi-word-key") "multiWordKey") => true
  (= (camel-case "leaveMeAlone") "leaveMeAlone") => true)

