(ns clj-linq.linq-projections
  (:require [clj-linq.data :refer :all]
            [clojure.string :as str]
            [clj-time.core  :as time]
            [clj-time.local :as ltime]))


;; linq6: Select - Simple 1
(defn linq6 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        nums-plus-one (map inc numbers)]
    (println "Numbers + 1:")
    (doseq [n nums-plus-one] (println n))))

;; linq7: Select - Simple 2
(defn linq7 []
  (let [products products-list
        product-names (map #(:product-name %) products)]
    (println "Product Names:")
    (doseq [x product-names] (println x))))

;; linq8: Select - Transformation
(defn linq8 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        text-nums (map #(strings %) numbers)]
    (println "Number strings:")
    (doseq [n text-nums] (println n))))

;; linq9: Select - Anonymous Types 1
(defn linq9 []
  (let [words ["aPPLE", "BlUeBeRrY", "cHeRry"]
        upper-lower-words
        (for [w words] { :lower (str/lower-case w), :upper (str/upper-case w)})]
    (doseq [ul upper-lower-words]
      (println "Uppercase:" (:upper ul) ", Lowercase:" (:lower ul)))))

;; linq10: Select - Anonymous Types 2
(defn linq10 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        digit-odd-evens
        (for [n numbers] {:digit (strings n), :even (= (mod n 2) 0)})]
    (doseq [d digit-odd-evens]
      (println "The digit" (:digit d) "is" (if (:even d) "even" "odd")))))

;; linq11: Select - Anonymous Types 3
(defn linq11 []
  (let [products products-list
        product-infos
        (for [p products]
          {:product-name (:product-name p), :category (:category p), :price (:unit-price p)})]
    (println "Product Info:")
    (doseq [p product-infos]
      (println (:product-name p) "is in the category" (:category p) "and costs" (:price p)))))

;; linq12: Select - Indexed
(defn linq12 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        nums-in-place
        (map-indexed (fn [i num] {:num num, :in-place (= num i)}) numbers)]
    (println "Number: In-place?")
    (doseq [n nums-in-place]
      (println (:num n) ":" (:in-place n)))))

;; linq13: Select - Filtered
(defn linq13 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        low-nums (for [n numbers
                       :when (< n 5)]
                   (digits n))]
    (println "Numbers < 5:")
    (doseq [n low-nums] (println n))))

;; linq14: SelectMany - Compound from 1
(defn linq14 []
  (let [numbers-a [0 2 4 5 6 8 9]
        numbers-b [1 3 5 7 8]
        pairs (for [a numbers-a
                    b numbers-b
                    :when (< a b)]
                {:a a, :b b})]
    (println "Pairs where a < b:")
    (doseq [pair pairs]
      (println (:a pair) "is less than" (:b pair)))))

;; linq15: SelectMany - Compound from 2
(defn linq15 []
  (let [customers customers-list
        orders
        (for [c customers
              o (:orders c)
              :when (< (:total o) 500)]
          {:customer-id (:customer-id c),
           :order-id (:order-id o),
           :total (:total o)})]
    (doseq [o orders] (println o))))

;; linq16: SelectMany - Compound from 3
(defn linq16 []
  (let [customers customers-list
        orders
        (for [c customers
              o (:orders c)
              :when (time/after? (:order-date o) (time/date-time 1998 1 1))]
          {:customer-id (:customer-id c),
           :order-id (:order-id o),
           :order-date (:order-date o)})]
    (doseq [o orders] (println o))))

;;linq17: SelectMany - from Assignment
(defn linq17 []
  (let [customers customers-list
        orders
        (for [c customers
              o (:orders c)
              :when (>= (:total o) 2000)]
          {:customer-id (:customer-id c), :order-id (:order-id o), :total (:total o)})]
    (doseq [o orders] (println o))))

;;linq18: SelectMany - Multiple from
(defn linq18 []
  (let [customers customers-list
        cutoff-date (time/date-time 1997 1 1)
        orders
        (for [c customers
              :when (= (:region c) "WA")
              o (:orders c)
              :when (time/after? (:order-date o) cutoff-date)]
          {:customer-id (:customer-id c), :order-id (:order-id o)})]
    (doseq [o orders] (println o))))

;;linq19: SelectMany - Indexed
(defn linq19 []
  (let [customers customers-list
        customer-orders
        (flatten
         (map-indexed
          (fn [i c]
            (map #(str "Customer #" (inc i) " has an order with OrderID " (:order-id %))
                 (:orders c)))
          customers))]
    (doseq [x customer-orders] (println x))))

(defn linq19 []
  (let [customers customers-list
        customer-orders
        (for [[i c] (map-indexed vector customers)
              o (:orders c)]
          (str "Customer #" (inc i) " has an order with OrderID " (:order-id o)))]
    (doseq [x customer-orders] (println x))))


(def examples [linq6  linq7  linq8 linq9 linq10 linq11 linq12 linq13 linq14 linq15 linq16
               linq17 linq18 linq19])






