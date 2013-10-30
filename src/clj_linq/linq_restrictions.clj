(ns clj-linq.linq-restrictions
  (:require [clj-linq.data :refer :all]))

;; linq1: Where - Simple 1
(defn linq1 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        low-numbers (for [n numbers :when (< n 5)] n)]
    (println "Numbers < 5:")
    (doseq [n low-numbers]
      (println n))))

;; linq2: Where - Simple 2
(defn linq2 []
  (let [products products-list
        sold-out-products (for [p products
                                :when (= 0 (:units-in-stock p))]
                            p)]
    (println "Sold out products:")
    (doseq [p sold-out-products]
      (println (:product-name p) " is sold out"))))

;; linq3: Where - Simple 3
(defn linq3 []
  (let [products products-list
        expensive-in-stock-products
        (for [p products-list
              :when (and
                     (> (:units-in-stock p) 0)
                     (> (:unit-price p) 3))]
          p)]
    (println "In-stock products that cost more than 3.00:")
    (doseq [p expensive-in-stock-products]
      (println (:product-name p) "is in stock and costs more than 3.00"))))

;; linq4: Where - Drilldown
(defn linq4 []
  (let [customers customers-list
        wa-customers (filter #(= (:region %) "WA") customers)]
    (println "Customers from Washington and their orders:")
    (doseq [c wa-customers]
      (println "Customer" (:customer-id c) ": " (:company-name c) ":")
      (doseq [o (:orders c)]
        (println "    Order" (:order-id o) ":" (:order-date o))))))

;; linq5: Where - Indexed
(defn linq5 []
  (let [digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        short-digits
        (for [[i digit] (map-indexed vector digits)
              :when (> i (count digit))]
          digit)]
    (println "Short digits:")
    (doseq [d short-digits]
      (println "The word" d "is shorter than its value"))))

(def examples [linq1 linq2 linq3 linq4 linq5])
