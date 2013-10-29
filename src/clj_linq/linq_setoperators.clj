(ns clj-linq.linq-setoperators
  (:require [clj-linq.data :refer :all]))

(use 'clojure.set)

;; linq46: Distinct - 1
(defn linq46 []
  (def factors-of-300 [2, 2, 3, 5, 5])
  (def unique-factors (distinct factors-of-300))

  (println "Prime factors of 300:")
  (doall (map println unique-factors))
)

;; linq47: Distinct - 2
(defn linq47 []
  (def products products-list)
  (def category-names (->> products
                           (map :category)
                           distinct))

  (println "Category names:")
  (doall (map println category-names))
)

;; linq48: Union - 1
(defn linq48 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def unique-numbers (union (set numbers-a) (set numbers-b)))

  (println "Unique numbers from both arrays:")
  (doall (map println unique-numbers))
)

;; linq49: Union - 2
(defn linq49 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def unique-first-chars (union (set product-first-chars) (set customer-first-chars)))

  (println "Unique first letters from Product names and Customer names:")
  (doall (map println unique-first-chars))
)

;; linq50: Intersect - 1
(defn linq50 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def common-numbers (intersection (set numbers-a) (set numbers-b)))

  (println "Common numbers shared by both arrays:")
  (doall (map println common-numbers))
)

;; linq51: Intersect - 2
(defn linq51 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def common-first-chars (intersection (set product-first-chars) (set customer-first-chars)))

  (println "Common first letters from Product names and Customer names:")
  (doall (map println common-first-chars))
)

;; linq52: Except - 1
(defn linq52 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def a-only-numbers (difference (set numbers-a) (set numbers-b)))

  (println "Numbers in first array but not second array:")
  (doall (map println a-only-numbers))
)

;; linq53: Except - 2
(defn linq53 []
  (def products products-list)
  (def customers customers-list)

  (def product-first-chars (map #(get (:product-name %) 0) products))
  (def customer-first-chars (map #(get (:company-name %) 0) customers))

  (def product-only-first-chars (difference (set product-first-chars) (set customer-first-chars)))

  (println "First letters from Product names, but not from Customer names:")
  (doall (map println product-only-first-chars))
)

(def examples [linq46 linq47 linq48 linq49 linq50 linq51 linq52 linq53])
