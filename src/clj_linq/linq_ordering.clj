(ns clj-linq.linq-ordering
  (:require [clj-linq.data :refer :all]))

(defn case-insensitive-compare [s1 s2]
  (compare (.toLowerCase s1) (.toLowerCase s2)))

(defn order-by-comparers [comparers xs]
  (sort-by
   pass-thru
   (fn [a1 a2]
     (nth (for [x (map #(% a1 a2) comparers)
                :when (not= x 0)] x)
          0 0))
   xs))

(defn order-by [fns xs]
  (sort-by (apply juxt fns) xs))


;; linq28: SkipWhile - Simple
(defn linq28 []
  (let [words ["cherry" "apple" "blueberry"]
        sorted-words (sort words)]
    (println "The sorted list of words:")
    (doseq [w sorted-words] (println w))))

;; linq29: OrderBy - Simple 2
(defn linq29 []
  (let [words ["cherry" "apple" "blueberry"]
        sorted-words (sort-by count words)]
    (println "The sorted list of words (by length):")
    (doseq [w sorted-words] (println w))))

;; linq30: OrderBy - Simple 3
(defn linq30 []
  (let [products products-list
        sorted-products (sort-by :product-name products)]
    (doseq [p sorted-products] (println p))))

;; linq31: OrderBy - Comparer
(defn linq31 []
  (let [words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"]
        sorted-words (sort-by identity case-insensitive-compare words)]
    (doseq [w sorted-words] (println w))))

;; linq32: OrderByDescending - Simple 1
(defn linq32 []
  (let [dbls [1.7 2.3 1.9 4.1 2.9]
        sorted-doubles (reverse (sort dbls))]
    (println "The doubles from highest to lowest:")
    (doseq [d sorted-doubles] (println d))))

;; linq33: OrderByDescending - Simple 2
(defn linq33 []
  (let [products products-list
        sorted-products (reverse (sort-by :units-in-stock products))]
    (doseq [p sorted-products] (println p))))

;; linq34: OrderByDescending - Comparer
(defn linq34 []
  (let [words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"]
        sorted-words (->> words
                          (sort-by identity case-insensitive-compare)
                          reverse)]
    (doseq [w sorted-words] (println w))))

;; linq35: ThenBy - Simple
(defn linq35 []
  (let [digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        sorted-digits (order-by [count identity] digits)]
    (println "Sorted digits:")
    (doseq [d sorted-digits] (println d))))

;; linq36: ThenBy - Comparer
(defn linq36 []
  (let [words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"]
        sorted-words (order-by [count (fn [x] (.toLowerCase x))] words)]
    (doseq [w sorted-words] (println w))))

;; linq37: ThenByDescending - Simple
(defn linq37 []
  (let [products products-list
        sorted-products (order-by [:category #(* -1 (:unit-price  %))] products)]
    (doseq [p sorted-products] (println p))))

;; linq38: ThenByDescending - Comparer
(defn linq38 []
  (let [words ["aPPLE" "AbAcUs" "bRaNcH" "BlUeBeRrY" "ClOvEr" "cHeRry"]
        sorted-words (order-by-comparers
                      [#(compare (count %1) (count %2))
                       #(case-insensitive-compare %2 %1)]
                      words)]
    (doseq [w sorted-words] (println w))))

;; linq39: Reverse
(defn linq39 []
  (let [digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        sorted-digits (->> digits
                           (filter #(= (get % 1) \i))
                           reverse)]
    (println "A backwards list of the digits with a second character of 'i':")
    (doseq [d sorted-digits] (println d))))

(def examples [linq28 linq29 linq30 linq31 linq32 linq33 linq34 linq35 linq36 linq37 linq38 linq39])
