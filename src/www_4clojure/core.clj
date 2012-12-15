(ns www-4clojure.core)

(defn last-element
  "Problem 19"
  [x]
  (first (drop (- (count x) 1) x)))

(defn penultimate-element
  "Problem 20"
  [l]
  (last (take (- (count l) 1) l)))
