(ns clj-linq.linq-elementoperators
  (:require [clj-linq.data :refer :all]))

;; linq58: First - Simple
(defn linq58 []
  (def products products-list)

  (def product-12 (->> products
                      (filter #(= (:product-id %) 12))
                       first))

  (println product-12)
)

;; linq59: First - Condition
(defn linq59 []
  (def strings ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"])

  (def starts-with-o (first (filter #(= (get % 0) \o) strings)))

  (println "A string starting with 'o':" starts-with-o)
)

;; linq61: FirstOrDefault - Simple
(defn linq61 []
  (def numbers [])

  (def first-num-or-default (get numbers 0 0))

  (println first-num-or-default)
)

;; linq62: FirstOrDefault - Condition
(defn linq62 []
  (def products products-list)

  (def product-789 (->> products
                      (filter #(= (:product-id %) 789))
                       first))

  (println "Product 789 exists:" (not= product-789 nil))
)

;; linq64: ElementAt
(defn linq64 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def fourth-low-num (->> numbers
                      (filter #(> % 5))
                       second))

  (println "Second number > 5:" fourth-low-num)
)

;; linq65: Range
(defn linq65 []

  (def numbers (map #(hash-map
                     :number %,
                     :odd-even (if (= (mod % 2) 1) "odd" "even"))
                    (range 100 151)))

  (doall (map #(println "The number" (:number %) "is" (:odd-even %)) numbers))
)

;; linq66: Repeat
(defn linq66 []
  (def numbers (repeat 10 7))
  (doall (map println numbers))
)


(def examples [linq58 linq59 linq61 linq62 linq64 linq65 linq66])



