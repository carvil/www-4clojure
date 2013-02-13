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
