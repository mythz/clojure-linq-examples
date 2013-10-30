(ns clj-linq.linq-miscoperators
  (:require [clj-linq.data :refer :all]))

;; linq94: Concat - 1
(defn linq94 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def all-numbers (flatten [numbers-a numbers-b]))

  (println "All numbers from both arrays:")
  (doall (map println all-numbers))
)

;; linq95: Concat - 2
(defn linq95 []
  (def products products-list)
  (def customers customers-list)

  (def customer-names (map :company-name customers))
  (def product-names (map :product-name products))

  (def all-names (flatten [customer-names product-names]))

  (println "Customer and product names:")
  (doall (map println all-names))
)

;; linq96: EqualAll - 1
(defn linq96 []
  (def words-a ["cherry" "apple" "blueberry"])
  (def words-b ["cherry" "apple" "blueberry"])

  (def match (= words-a words-b))

  (println "The sequences match:" match)
)

;; linq97: EqualAll - 2
(defn linq97 []
  (def words-a ["cherry" "apple" "blueberry"])
  (def words-b ["apple" "blueberry" "cherry"])

  (def match (= words-a words-b))

  (println "The sequences match:" match)
)

(def examples [linq94 linq95 linq96 linq97])
