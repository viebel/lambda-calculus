(ns lambda-calculus.macros
  (:require [lambda-calculus.core :refer [Lambda]]))
  
(defmacro lambda [name args & body]
  `(defn ~name ~args (Lambda. ~@body)))
