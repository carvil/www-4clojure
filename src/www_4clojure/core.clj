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
