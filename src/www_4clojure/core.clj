(ns www-4clojure.core)

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
