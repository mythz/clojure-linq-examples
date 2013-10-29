(ns clj-linq.linq-ordering
  (:require [clj-linq.data :refer :all]))

(defn case-insensitive-compare [s1 s2]
  (compare (.toLowerCase s1) (.toLowerCase s2)))

(defn order-by-comparers [comparers xs]
  (sort-by
   pass-thru
   (fn [a1 a2]
     (let [ret (first (drop-while #(= 0 %) (map #(% a1 a2) comparers)))]
       (if (nil? ret) 0 ret)))
   xs))

(defn order-by [fns xs]
  (order-by-comparers (map #(fn [a1 a2] (compare (% a1) (% a2))) fns) xs))


;; linq28: SkipWhile - Simple
(defn linq28 []
  (def words ["cherry" "apple" "blueberry"])
  (def sorted-words (sort words))

  (println "The sorted list of words:")
  (doall (map println sorted-words))
)

;; linq29: OrderBy - Simple 2
(defn linq29 []
  (def words ["cherry" "apple" "blueberry"])
  (def sorted-words (sort-by count words))

  (println "The sorted list of words (by length):")
  (doall (map println sorted-words))
)

;; linq30: OrderBy - Simple 3
(defn linq30 []
  (def products products-list)
  (def sorted-products (sort-by :product-name products))

  (doall (map println sorted-products))
)

;; linq31: OrderBy - Comparer
(defn linq31 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (sort-by identity case-insensitive-compare words))

  (doall (map println sorted-words))
)

;; linq32: OrderByDescending - Simple 1
(defn linq32 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])
  (def sorted-doubles (reverse (sort dbls)))

  (println "The doubles from highest to lowest:")
  (doall (map println sorted-doubles))
)

;; linq33: OrderByDescending - Simple 2
(defn linq33 []
  (def products products-list)
  (def sorted-products (reverse (sort-by :units-in-stock products)))

  (doall (map println sorted-products))
)

;; linq34: OrderByDescending - Comparer
(defn linq34 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (->> words
                         (sort-by identity case-insensitive-compare)
                         reverse))

  (doall (map println sorted-words))
)

;; linq35: ThenBy - Simple
(defn linq35 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def sorted-digits (order-by [count identity] digits))

  (println "Sorted digits:")
  (doall (map println sorted-digits))
)

;; linq36: ThenBy - Comparer
(defn linq36 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (order-by [count (fn [x] (.toLowerCase x))] words))

  (doall (map println sorted-words))
)

;; linq37: ThenByDescending - Simple
(defn linq37 []
  (def products products-list)
  (def sorted-products (order-by [:category #(* -1 (:unit-price  %))] products))

  (doall (map println sorted-products))
)

;; linq38: ThenByDescending - Comparer
(defn linq38 []
  (def words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"])
  (def sorted-words (order-by-comparers
                     [#(compare (count %1) (count %2))
                      #(case-insensitive-compare %2 %1)]
                     words))

  (doall (map println sorted-words))
)

;;linq39: Reverse
(defn linq39 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def sorted-digits (->> digits
                          (filter #(= (get % 1) \i))
                          reverse))

  (println "Sorted digits:")
  (doall (map println sorted-digits))
)

(def examples [linq28 linq29 linq30 linq31 linq32 linq33 linq34 linq35 linq36 linq37 linq38 linq39])
