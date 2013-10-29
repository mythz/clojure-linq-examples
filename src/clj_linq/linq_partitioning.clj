(ns clj-linq.linq-partitioning
  (:require [clj-linq.data :refer :all]))


;; linq20: Select - Simple 1
(defn linq20 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-3-numbers (take 3 numbers))

  (println "First 3 numbers:")
  (doall (map println first-3-numbers))
)

;; linq21: Take - Nested
(defn linq21 []
  (def customers customers-list)

  (def first-3-wa-orders
    (take 3 (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c),
                        :order-id (:order-id %),
                        :order-date (:order-date %))
             (:orders c)))
      (filter #(= (:region %) "WA") customers)))))

  (println "First 3 orders in WA:")
  (doall (map println first-3-wa-orders))
)

;; linq22: Skip - Simple
(defn linq22 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def all-but-first-4-numbers (drop 4 numbers))

  (println "All but first 4 numbers:")
  (doall (map println all-but-first-4-numbers))
)

;; linq23: Skip - Nested
(defn linq23 []
  (def customers customers-list)

  (def all-but-first-2-orders
    (drop 2 (flatten
     (map
      (fn [c]
        (map #(hash-map :customer-id (:customer-id c),
                        :order-id (:order-id %),
                        :order-date (:order-date %))
             (:orders c)))
      (filter #(= (:region %) "WA") customers)))))

  (println "All but first 2 orders in WA:")
  (doall (map println all-but-first-2-orders))
)

;; linq24: TakeWhile - Simple
(defn linq24 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-numbers-less-than-6 (take-while #(< % 6) numbers))

  (println "First numbers less than 6:")
  (doall (map println first-numbers-less-than-6))
)

;; linq25: TakeWhile - Indexed
(defn linq25 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def first-small-numbers
    (map (fn [[i num]] num)
      (take-while (fn [[i num]] (>= num i)) (with-index numbers))))

  (println "First numbers not less than their position:")
  (doall (map println first-small-numbers))
)

;; linq26: SkipWhile - Simple
(defn linq26 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def all-but-first-3-numbers (drop-while #(not= (mod % 3) 0) numbers))

  (println "All elements starting from first element divisible by 3:")
  (doall (map println all-but-first-3-numbers))
)

;; linq27: SkipWhile - Indexed
(defn linq27 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def later-numbers
    (map (fn [[i num]] num)
      (drop-while (fn [[i num]] (>= num i)) (with-index numbers))))

  (println "All elements starting from first element less than its position:")
  (doall (map println later-numbers))
)


(def examples [linq20 linq21 linq22 linq23 linq24 linq25 linq26 linq27])
