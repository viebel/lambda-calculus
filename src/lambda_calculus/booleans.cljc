(ns lambda-calculus.booleans
  (:require [lambda-calculus.core :refer [->LambdaBool]])
  (:require-macros [lambda-calculus.macros :refer [lambda-bool]]))


(def T (->LambdaBool
         (fn [x]
           (fn [y] x))))
           
(def F (->LambdaBool
         (fn [x]
           (fn [y] y))))
           
(lambda-bool negation [x]
    ((x F) T))

      
