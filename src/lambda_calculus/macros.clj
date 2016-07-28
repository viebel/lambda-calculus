(ns lambda-calculus.macros
  (:require [lambda-calculus.core :refer [->Lambda ->LambdaBool]]))
  
(defmacro lambda [name args & body]
  `(defn ~name ~args (->Lambda ~@body)))

(defmacro lambda-bool [name args & body]
  `(defn ~name ~args (->LambdaBool ~@body)))
