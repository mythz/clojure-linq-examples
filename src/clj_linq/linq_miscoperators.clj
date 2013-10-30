(ns clj-linq.linq-miscoperators
  (:require [clj-linq.data :refer :all]))

;; linq94: Concat - 1
(defn linq94 []
  (let [numbers-a [0 2 4 5 6 8 9]
        numbers-b [1 3 5 7 8]
        all-numbers (flatten [numbers-a numbers-b])]
    (println "All numbers from both arrays:")
    (doseq [n all-numbers] (println n))))

;; linq95: Concat - 2
(defn linq95 []
  (let [products products-list
        customers customers-list
        customer-names (map :company-name customers)
        product-names (map :product-name products)
        all-names (flatten [customer-names product-names])]
    (println "Customer and product names:")
    (doseq [x all-names] (println x))))

;; linq96: EqualAll - 1
(defn linq96 []
  (let [words-a ["cherry" "apple" "blueberry"]
        words-b ["cherry" "apple" "blueberry"]
        match (= words-a words-b)]
    (println "The sequences match:" match)))

;; linq97: EqualAll - 2
(defn linq97 []
  (let [words-a ["cherry" "apple" "blueberry"]
        words-b ["apple" "blueberry" "cherry"]
        match (= words-a words-b)]
    (println "The sequences match:" match)))

(def examples [linq94 linq95 linq96 linq97])
