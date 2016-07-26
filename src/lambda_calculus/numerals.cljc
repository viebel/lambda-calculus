(ns lambda-calculus.numerals
  (:refer-clojure :exclude [+ - * inc dec])
  (:require-macros [lambda-calculus.macros :refer [lambda]]))
  
(lambda numeral [n]
    (fn [f]
      (fn [x]
        ((apply comp (repeat n f)) x))))
      
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
  
(lambda predecessor [n]
        (fn [f]
          (fn [x]
            (((n 
                (fn [g] (fn [h] (h (g f))))) 
              (fn [u] x))
             (fn [u] u)))))

(lambda sub [m n]
        ((n predecessor) m))
      
(lambda exponent [m n]
        (n m))

(def num numeral)
(def - sub)
(def + add)
(def * mult)
(def ** exponent)
(def dec predecessor)
(def inc successor)



