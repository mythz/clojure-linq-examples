(ns clj-linq.linq-quantifiers
  (:require [clj-linq.data :refer :all]))

;; linq67: Any - Simple
(defn linq67 []
  (def words ["believe" "relief" "receipt" "field"])

  (def i-after-e (some #(.contains % "ie") words))

  (println "There is a word that contains in the list that contains 'ei':" i-after-e)
)

;; linq69: Any - Grouped
(defn linq69 []
  (def products products-list)

  (def product-groups
    (->> products
         (group-by :category)
         (filter #(some (fn [p] (= (:units-in-stock p) 0)) (get % 1)))
         (map #(hash-map :category (get % 0), :products (get % 1)))
         ))

  (doall (map println product-groups))
)

;; linq70: All - Simple
(defn linq70 []
  (def numbers [1 11 3 19 41 65 19])

  (def only-odd (every? #(= (mod % 2) 1) numbers))

  (println "The list contains only odd numbers:" only-odd)
)

;; linq72: All - Grouped
(defn linq72 []
  (def products products-list)

  (def product-groups
    (->> products
         (group-by :category)
         (filter #(every? (fn [p] (> (:units-in-stock p) 0)) (get % 1)))
         (map #(hash-map :category (get % 0), :products (get % 1)))
         ))

  (doall (map println product-groups))
)

(def examples [linq67 linq69 linq70 linq72])
