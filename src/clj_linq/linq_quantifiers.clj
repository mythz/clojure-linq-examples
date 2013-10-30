(ns clj-linq.linq-quantifiers
  (:require [clj-linq.data :refer :all]))

;; linq67: Any - Simple
(defn linq67 []
  (let [words ["believe" "relief" "receipt" "field"]
        i-after-e (some #(.contains % "ie") words)]
    (println "There is a word that contains in the list that contains 'ei':" i-after-e)))

;; linq69: Any - Grouped
(defn linq69 []
  (let [products products-list
        product-groups
        (->> products
             (group-by :category)
             (filter #(some (fn [p] (= (:units-in-stock p) 0)) (get % 1)))
             (map #(identity {:category (first %), :products (second %)})))]
    (doseq [x product-groups] (println x))))

;; linq70: All - Simple
(defn linq70 []
  (let [numbers [1 11 3 19 41 65 19]
        only-odd (every? #(= (mod % 2) 1) numbers)]
    (println "The list contains only odd numbers:" only-odd)))

;; linq72: All - Grouped
(defn linq72 []
  (let [products products-list
        product-groups
        (->> products
             (group-by :category)
             (filter #(every? (fn [p] (> (:units-in-stock p) 0)) (second %)))
             (map #(identity {:category (first %), :products (second %)})))]
    (doseq [x product-groups] (println x))))

(def examples [linq67 linq69 linq70 linq72])
