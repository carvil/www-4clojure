(ns www-4clojure.core)

(defn last-element
  "Problem 19"
  [x]
  (first (drop (- (count x) 1) x)))
