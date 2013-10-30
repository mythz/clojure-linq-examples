(ns clj-linq.linq-setoperators
  (:require [clj-linq.data :refer :all]))

(use 'clojure.set)

;; linq46: Distinct - 1
(defn linq46 []
  (let [factors-of-300 [2, 2, 3, 5, 5]
        unique-factors (distinct factors-of-300)]
    (println "Prime factors of 300:")
    (doseq [n unique-factors] (println n))))

;; linq47: Distinct - 2
(defn linq47 []
  (let [products products-list
        category-names (->> products
                            (map :category)
                            distinct)]
    (println "Category names:")
    (doseq [c category-names] (println c))))

;; linq48: Union - 1
(defn linq48 []
  (let [numbers-a [0 2 4 5 6 8 9]
        numbers-b [1 3 5 7 8]
        unique-numbers (union (set numbers-a) (set numbers-b))]
    (println "Unique numbers from both arrays:")
    (doseq [n unique-numbers] (println n))))

;; linq49: Union - 2
(defn linq49 []
  (let [products products-list
        customers customers-list
        product-first-chars (map #(first (:product-name %)) products)
        customer-first-chars (map #(first (:company-name %)) customers)
        unique-first-chars (union (set product-first-chars) (set customer-first-chars))]
    (println "Unique first letters from Product names and Customer names:")
    (doseq [x unique-first-chars] (println x))))

;; linq50: Intersect - 1
(defn linq50 []
  (let [numbers-a [0 2 4 5 6 8 9]
        numbers-b [1 3 5 7 8]
        common-numbers (intersection (set numbers-a) (set numbers-b))]
    (println "Common numbers shared by both arrays:")
    (doseq [n common-numbers] (println n))))

;; linq51: Intersect - 2
(defn linq51 []
  (let [products products-list
        customers customers-list
        product-first-chars (map #(first (:product-name %)) products)
        customer-first-chars (map #(first (:company-name %)) customers)
        common-first-chars (intersection (set product-first-chars) (set customer-first-chars))]
    (println "Common first letters from Product names and Customer names:")
    (doseq [x common-first-chars] (println x))))

;; linq52: Except - 1
(defn linq52 []
  (let [numbers-a [0 2 4 5 6 8 9]
        numbers-b [1 3 5 7 8]
        a-only-numbers (difference (set numbers-a) (set numbers-b))]
  (println "Numbers in first array but not second array:")
  (doseq [n a-only-numbers] (println n))))

;; linq53: Except - 2
(defn linq53 []
  (let [products products-list
        customers customers-list
        product-first-chars (map #(first (:product-name %)) products)
        customer-first-chars (map #(first (:company-name %)) customers)
        product-only-first-chars (difference (set product-first-chars) (set customer-first-chars))]
    (println "First letters from Product names, but not from Customer names:")
    (doseq [x  product-only-first-chars] (println x))))

(def examples [linq46 linq47 linq48 linq49 linq50 linq51 linq52 linq53])
