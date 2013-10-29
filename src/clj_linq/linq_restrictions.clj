(ns clj-linq.linq-restrictions
  (:require [clj-linq.data :refer :all]))

;; linq1: Where - Simple 1
(defn linq1 []
  (def numbers [4 5 1 3 9 8 6 7 2 0])

  (def low-nums (filter #(< % 5) numbers))

  (println "Numbers < 5:")
  (doall (map println low-nums))
)

;; linq2: Where - Simple 2
(defn linq2 []
  (def products products-list)
  (def sold-out-products
    (filter #(= 0 (:units-in-stock %))
            products))

  (println "Sold out products:")
  (doseq [p sold-out-products]
    (println (:product-name p) " is sold out"))
)

;; linq3: Where - Simple 3
(defn linq3 []
  (def products products-list)
  (def expensive-in-stock-products
    (filter #(and
               (> 0 (:units-in-stock %))
               (> 3 (:unit-price %)))
            products))

  (println "In-stock products that cost more than 3.00:")
  (doseq [p sold-out-products]
    (println (:product-name p) "is in stock and costs more than 3.00"))
)

;; linq4: Where - Drilldown
(defn linq4 []
  (def customers customers-list)
  (def wa-customers
    (filter #(= (:region %) "WA") customers))

  (println "Customers from Washington and their orders:")
  (doseq [c wa-customers]
    (println "Customer" (:customer-id c) ": " (:company-name c) ":")
    (doseq [o (:orders c)]
      (println "    Order" (:order-id o) ":" (:order-date o)))
  )
)

;; linq5: Where - Indexed
(defn linq5 []
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
  (def short-digits
    (map last
         (filter (fn [[i digit]] (> i (count digit)))
                 (map-indexed (fn [i digit] [i digit]) digits))))

  (println "Short digits:")
  (doseq [d short-digits]
    (println "The word" d "is shorter than its value"))
)

(def examples [linq1 linq2 linq3 linq4 linq5])
