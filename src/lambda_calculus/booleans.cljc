(ns lambda-calculus.booleans
  (:refer-clojure :exclude [not and or])
  (:require [lambda-calculus.core :refer [->LambdaBool]])
  (:require-macros [lambda-calculus.macros :refer [lambda-bool]]))


(def T (->LambdaBool
         (fn [x]
           (fn [y] x))))
           
(def F (->LambdaBool
         (fn [x]
           (fn [y] y))))
           
(lambda-bool negation [x]
    (x F T))
  
(lambda-bool conjunction [x]
    (fn [y]
      (x y F)))
    
(lambda-bool disjunction [x]
    (fn [y]
      (x T y)))
    

(def not negation)
(def and conjunction)
(def or disjunction)
