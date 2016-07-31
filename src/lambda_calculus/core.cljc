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
           (f g))
  (-invoke [this g h]
           ((f g) h)))

(defn view-bool [bool]
  ((bool "T") "F"))

(deftype LambdaBool [f]
  Object
  (toString [_] (str (view-bool f)))
  IPrintWithWriter
  (-pr-writer [this writer _] (-write writer (str (view-bool f))))
  IEquiv
  (-equiv [this other]
          (= (view-bool this) (view-bool other)))
  IFn
  (-invoke [this g]
           (f g))
  (-invoke [this g h]
           ((f g) h))
  (-invoke [this g h i]
           ((f g) h i))
  (-invoke [this g h i j]
           ((f g) h i j))
  (-invoke [this g h i j k]
           ((f g) h i j k))
  (-invoke [this g h i j k l]
           ((f g) h i j k l))
  (-invoke [this g h i j k l m]
           ((f g) h i j k l m)))

