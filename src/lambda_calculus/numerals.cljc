(ns lambda-calculus.numerals
  (:require-macros [lambda-calculus.macros :refer [lambda]]))
  
(lambda numeral [n]
    (fn [f]
      (fn [x]
        ((apply comp (repeat n f)) x))))
      
(def num numeral)
        
(lambda successor [m]
  (fn [f]
    (fn [x]
      (f ((m f) x)))))
      
(lambda add [m n]
  (fn [f]
    (fn [x]
      ((n f) ((m f) x)))))

(lambda mult [m n]
  (fn [f]
    (m (n f))))


