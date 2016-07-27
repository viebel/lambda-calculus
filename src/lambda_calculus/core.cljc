(ns lambda-calculus.core)

(defn visual [x]
  (list 'f x))

(defn view [f]
  ((f visual) 'x))

(deftype Lambda [f]
  Object
  (toString [_] (str (view f)))

  IPrintWithWriter
  (-pr-writer [this writer _] (-write writer (str (view f))))
  
   IEquiv
  (-equiv [this other]
          (= (view this) (view other)))

  IFn
  (-invoke [this g]
           (f g)))
