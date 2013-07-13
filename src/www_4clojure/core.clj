(ns www-4clojure.core
  (:require clojure.set))

(defn last-element
  "Problem 19"
  [x]
  (first (drop (- (count x) 1) x)))

(defn penultimate-element
  "Problem 20"
  [l]
  (last (take (- (count l) 1) l)))

(defn nth-element
  "Problem 21"
  [s n]
  (first (drop n s)))

(defn count-a-sequence
  "Problem 22"
  [s]
  (reduce + (map (fn [_] 1) s)))

(defn sum-it-all-up
  "Problem 24"
  [s]
  (reduce + s))

(defn find-the-odds
  "Problem 25"
  [s]
  (filter odd? s))

(defn reverse-a-sequence
  "Problem 23"
  [s]
  (reduce conj '() s))

(defn palindrome-detector
  "Problem 27"
  [s]
  (let [sq (seq s)] (= sq (reverse sq))))

(defn fibonacci-sequence
  "Problem 26"
  [n]
  (letfn [(fib
    ([] (concat [1] (fib 0 1)))
    ([a b] (cons (+ a b) (lazy-seq (fib b (+ a b))))))]
    (take n (fib))))

(defn flatten-seq
  "Problem 28 - Flatten a Sequence"
  [s]
  (lazy-seq
    (if (empty? s)
      s
      (let [[head & tail] s]
        (if (sequential? head)
          (concat (flatten-seq head) (flatten-seq tail))
          (cons head (flatten-seq tail)))))))

(defn get-the-caps
  "Problem 29 - Get the Caps"
  [s]
  (apply str (filter (fn [c] (java.lang.Character/isUpperCase c)) (seq s))))

(defn compress-seq
  "Problem 30 - Compress a Sequence"
  [s]
  (if (empty? s)
    []
    (let [[head & tail] s]
    (if (= head (first tail))
      (compress-seq tail)
      (cons head (compress-seq tail))))))

(defn pack-seq
  "Problem 31 - Pack a Sequence"
  [s]
  (if (empty? s)
    []
    (let [head (first s)
          sub-list (take-while #(= head %) s)
          tail (drop (count sub-list) s)]
      (cons sub-list (pack-seq tail)))))

(defn replicate-seq
  "Problem 33 - Replicate a sequence"
  [s n]
  (loop [original s, result []]
    (if (seq original)
      (recur
        (rest original)
        (concat result (repeat n (first original))))
    result)))

(defn dup-seq
  "Problem 32 - Duplicate a sequence"
  [s]
  (replicate-seq s 2))

(defn my-range
  "problem 34 - implement range"
  [f t]
  (loop [from f, to t, result []]
    (if (not= from to)
      (recur
        (+ from 1)
        t
        (conj result from))
      result)))

(defn foldl
  "Implementation of foldl in clojure"
  [acc predicate l]
  (if (empty? l)
    acc
    (recur
      (predicate acc (first l))
      predicate
      (drop 1 l))))

(defn maximum-val
  "Problem 38 - maximum value"
  ([] nil)
  ([x] x)
  ([x & others] (foldl x (fn [a,b] (if (> a b) a b)) (seq others))))

(defn interleave-seqs
  "Problem 30 - Interleave two sequences"
  [s1 s2]
  (flatten (map vector s1 s2)))

(defn interpose-seq
  "Problem 40 - Interpose a sequence"
  [sep s]
  (let [sep-seq (repeat (count s) sep)]
    (drop-last (interleave s sep-seq))))

(defn drop-last-if-same-size
  "Drops last element of sequence if predicate is true"
  [n l]
  (if (= n (count l))
    (drop-last l)
    l))

(defn drop-every-nth
  "Problem 41 - Drop every nth element"
  [s n]
  (mapcat #(drop-last-if-same-size n %) (partition-all n s)))

(defn factorial
  "Problem 42 - Factorial"
  [n]
  (if (= n 0)
    1
    (* n (factorial (- n 1)))))

(defn reverse-interleave
  "Problem 43 - Reverse interleave"
  [s n]
  (apply map list (partition-all n s)))

(defn rotate-sequence
  "Problem 44 - Rotate a Sequence"
  [n s]
  (flatten (reverse (split-at (mod n (count s)) s))))

(defn flipping-out
  "Problem 46 - Flipping out"
  [function]
  (fn [& args] (apply function (reverse args))))

(defn split-a-sequence
  "Problem 49 - Split a sequence"
  [n s]
  (list (take n s) (drop n s)))

(defn a-nil-key
  "Problem 134 - A nil key"
  [k m]
  (and (contains? m k) (= (get m k) nil)))

(defn map-defaults
  "Problem 156 - Map defaults"
  [v s]
  (zipmap s (repeat (count s) v)))

(defn derive-comparison
  "Problem 166 - Comparions"
  [op item1 item2]
  (cond (op item1 item2) :lt
        (op item2 item1) :gt
        :else :eq))

(defn map-cons
  "Problem 61 - Map construction"
  [ks vs]
  (apply assoc {} (interleave ks vs)))

(defn gcd
  "Problem 66 - Greatest Common Divisor using Euclidean algorithm"
  [a b]
  (if (= b 0)
    a
    (recur b (mod a b))))

(defn my-intersection
  "Problem 81 - set intersection"
  [s1 s2]
  (clojure.set/select (fn [e] (contains? s2 e)) s1))

(defn infinite-seq
  "Problem 62 - Re-implement Iterate"
  [f x]
  (let [appl (f x)]
    (cons x (lazy-seq (infinite-seq f appl)))))

(defn exp
  "Exponentiation"
  [x n] (reduce * (repeat n x)))

(defn simple-closure
  "Problem 107 - simple closure"
  [n]
  (fn [x] (exp x n)))

(defn product-digits
  "Problem 99 - product digits"
  [a b]
  (map (fn [c] (Integer. (str c))) (seq (str (* a b)))))

(defn read-bin
  "Problem 122 - Read a binary number"
  [bin]
  (reduce + (map-indexed (fn [idx item] (* (Integer. (str item)) (exp 2 idx))) (reverse bin))))

(defn dot-product
  "Problem 143 - Dot product"
  [s1 s2]
  (loop [memo []
         my-s1 s1
         my-s2 s2]
    (if (empty? my-s1)
      (reduce + memo)
      (recur (conj memo (* (first my-s1) (first my-s2))) (rest my-s1) (rest my-s2)))))

(defn infix
  "Problem 135 - infix calculator"
  [& args]
  (loop [my-args args]
    (if (= 1 (count my-args))
      (first my-args)
      (let [[a op b & more] my-args]
        (recur (cons (op a b) more))))))

(defn my-map
  "Re-implement Map"
  [f lst]
  (if (empty? lst)
      lst
      (cons (f (first lst)) (lazy-seq (my-map f (rest lst))))))

(defn indexing-seq
  "Problem 157 - Indexing sequences"
  [s]
  (map-indexed (fn [idx item] [item idx]) s))

(defn sum-sq-digits
  "Problem 120 - Sum of square of digits"
  [s]
  (letfn [(num-to-digits [n]
            (map (fn [d] (Character/digit d 10)) (str n)))
          (sum-sq [l]
            (apply + (map (fn [x] (* x x)) l)))
          (is-smaller? [d]
            (let [sum (sum-sq (num-to-digits d))]
              (< d sum)))]
    (count (filter #{true} (map is-smaller? s)))))

(defn half-truth
  "Problem 83 - a half truth"
  [& args]
  (if (every? true? args)
    false
    (or (some true? args) false)))

(defn symmetric-diff
  "Problem 88 - Symetric difference between sets"
  [s1 s2]
  (let [diff-s1 (clojure.set/difference s1 s2)
        diff-s2 (clojure.set/difference s2 s1)]
    (clojure.set/union diff-s1 diff-s2)))

(defn gcd
  [a,b]
  (loop [a1 a b1 b]
    (if (zero? b1)
      a1
      (recur b1 (mod a1 b1)))))

(defn lcm-2
  [a b]
  (/ (* a b) (gcd a b)))

(defn lcm
  "Problem 100 - LCM"
  [& args]
  (reduce lcm-2 args))

(defn update-map
  [f element m]
  (let [k (f element)
        current-value (get m k [])
        new-value (vec (conj current-value element))]
    (assoc m k new-value)))

(defn my-group-by
  "Problem 62 - Group a Sequence"
  [f s]
  (loop [m {} l s]
    (if (empty? l)
      m
      ( recur (update-map f (first l) m) (rest l)))))

(defn split-by-type [s]
  "Problem 50 - split by type"
  (letfn [(to-map [e] {(type e) (conj '() e)})]
    (vals (reduce #(merge-with concat %1 %2) (map to-map s)))))


(defn count-occur
  "Problem 55 - count occurrences"
  [s]
  (let [groups (group-by identity s)]
    (zipmap (keys groups) (map count (vals groups)))))


(defn pairwise-disjoint-sets
  "Problem 153 - Pairwise Disjoint Sets"
  [s]
  (let [elem-lst (mapcat seq s)
        uniq-lst (distinct elem-lst)]
    (= elem-lst uniq-lst)))


(defn cartesian-product
  "Problem 90 - cartesian product"
  [& args]
  (set (reduce #(for [e1 %1 e2 %2] (vector e1 e2)) args)))


(defn camel-case
  "Problem 102 - camel case"
  [s]
  (let [[start & more] (clojure.string/split s #"\-")]
    (apply str (conj (map clojure.string/capitalize more) start))))

(defn word-sorting
  "Problem 70 - word sorting"
  [s]
  (sort
    #(compare (clojure.string/upper-case %1) (clojure.string/upper-case %2))
    (re-seq #"\w+" s)))

(defn pascal-line [limit]
  "Problem 97 - Pascal's Triangle (calculating row by itself by following an
   alrorithm which doesn't require  computing other elements or factorials."
  (letfn [(f [k-1 k n]
          (long (* k-1 (/ (+ n (- 1 k)) k))))]
    (loop [prev-k 1, k 1, n (- limit 1), res [1]]
    (if (> k n)
      res
      (recur (f prev-k k n) (+ k 1) n (conj res (f prev-k k n)))))))

(defn my-distinct [s]
  "Problem 56 - my distinct"
  (sort-by #(.indexOf s %) (into (empty s) (into #{} s))))
