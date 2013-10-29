(ns clj-linq.linq-projections
  (:require [clj-linq.data :refer :all]
            [clojure.string :as str]
            [clj-time.core  :as time]
            [clj-time.local :as ltime]))


;; linq6: Select - Simple 1
(defn linq6 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def nums-plus-one (map inc numbers))

  (println "Numbers + 1:")
  (doall (map println nums-plus-one))
)

;; linq7: Select - Simple 2
(defn linq7 []
  (def products products-list)
  (def product-names (map #(:product-name %) products))

  (println "Product Names:")
  (doall (map println product-names))
)

;; linq8: Select - Transformation
(defn linq8 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def text-nums (map #(strings %) numbers))

  (println "Number strings:")
  (doall (map println text-nums))
)

;; linq9: Select - Anonymous Types 1
(defn linq9 []
  (def words ["aPPLE", "BlUeBeRrY", "cHeRry"])

  (def upper-lower-words
    (map #(hash-map :lower (str/lower-case %), :upper (str/upper-case %)) words))

  (doseq [ul upper-lower-words]
    (println "Uppercase:" (:upper ul) ", Lowercase:" (:lower ul)))
)

;; linq10: Select - Anonymous Types 2
(defn linq10 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def strings ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def digit-odd-evens
    (map (fn [n] {:digit (strings n), :even (= (mod n 2) 0)}) numbers))

  (doseq [d digit-odd-evens]
    (println "The digit" (:digit d) "is" (if (:even d) "even" "odd")))
)

;; linq11: Select - Anonymous Types 3
(defn linq11 []
  (def products products-list)

  (def product-infos
    (map #(hash-map :product-name (:product-name %), :category (:category %), :price (:unit-price %)) products))

  (println "Product Info:")
  (doseq [p product-infos]
    (println (:product-name p) "is in the category" (:category p) "and costs" (:price p)))
)

;; linq12: Select - Indexed
(defn linq12 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def nums-in-place
    (map-indexed (fn [i num] {:num num, :in-place (= num i)}) numbers))

  (println "Number: In-place?")
  (doseq [n nums-in-place]
    (println (:num n) ":" (:in-place n)))
)

;; linq13: Select - Filtered
(defn linq13 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def digits ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

  (def low-nums
    (map #(digits %) (filter #(< % 5) numbers)))

  (println "Numbers < 5:")
  (doall (map println low-nums))
)

;; linq14: SelectMany - Compound from 1
(defn linq14 []
  (def numbers-a [0 2 4 5 6 8 9])
  (def numbers-b [1 3 5 7 8])

  (def pairs
    (flatten
      (map (fn [a] (map #(hash-map :a a, :b %)
                   (filter #(< a %) numbers-b)))
           numbers-a)))

  (println "Pairs where a < b:")
  (doseq [pair pairs]
    (println (:a pair) "is less than" (:b pair)))
)

;; linq15: SelectMany - Compound from 2
(defn linq15 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :total (:total %))
             (filter #(< (:total %) 500) (:orders c))))
      customers)))

  (doall (map println orders))
)

;; linq16: SelectMany - Compound from 3
(defn linq16 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :order-date (:order-date %))
             (filter #(time/after? (:order-date %) (time/date-time 1998 1 1))
                     (:orders c))))
      customers)))

  (doall (map println orders))
)

;;linq17: SelectMany - from Assignment
(defn linq17 []
  (def customers customers-list)

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %), :total (:total %))
             (filter #(>= (:total %) 2000) (:orders c))))
      customers)))

  (doall (map println orders))
)

;;linq18: SelectMany - Multiple from
(defn linq18 []
  (def customers customers-list)
  (def cutoff-date (time/date-time 1997 1 1))

  (def orders
    (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c), :order-id (:order-id %))
             (filter #(time/after? (:order-date %) cutoff-date)
                     (:orders c))))
      (filter #(= (:region %) "WA") customers))))

  (doall (map println orders))
)

;;linq19: SelectMany - Indexed
(defn linq19 []
  (def customers customers-list)

  (def customer-orders
    (flatten
     (map-indexed
      (fn [i c]
        (map #(str "Customer #" (inc i) " has an order with OrderID " (:order-id %))
             (:orders c)))
      customers)))

  (doall (map println customer-orders))
)

(def examples [linq6  linq7  linq8 linq9 linq10 linq11 linq12 linq13 linq14 linq15 linq16
               linq17 linq18 linq19])






