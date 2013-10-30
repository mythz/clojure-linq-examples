(ns clj-linq.linq-partitioning
  (:require [clj-linq.data :refer :all]))

;; linq20: Select - Simple 1
(defn linq20 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        first-3-numbers (take 3 numbers)]
    (println "First 3 numbers:")
    (doseq [n first-3-numbers] (println n))))

;; linq21: Take - Nested
(defn linq21 []
  (let [customers customers-list
        first-3-wa-orders
        (take 3
              (flatten
               (for [c customers
                     :when (= (:region c) "WA")]
                 (for [o (:orders c)]
                   {:customer-id (:customer-id c),
                    :order-id (:order-id o),
                    :order-date (:order-date o)}))))]
    (println "First 3 orders in WA:")
    (doseq [x first-3-wa-orders] (println x))))

;; linq22: Skip - Simple
(defn linq22 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        all-but-first-4-numbers (drop 4 numbers)]
    (println "All but first 4 numbers:")
    (doseq [n all-but-first-4-numbers] (println n))))

;; linq23: Skip - Nested
(defn linq23 []
  (let [customers customers-list
        all-but-first-2-orders
        (drop 2 (flatten
                 (for [c customers
                       :when (= (:region c) "WA")]
                   (for [o (:orders c)]
                     {:customer-id (:customer-id c),
                      :order-id (:order-id o),
                      :order-date (:order-date o)}))))]
    (println "All but first 2 orders in WA:")
    (doseq [o all-but-first-2-orders] (println o))))

;; linq24: TakeWhile - Simple
(defn linq24 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        first-numbers-less-than-6 (take-while #(< % 6) numbers)]
    (println "First numbers less than 6:")
    (doseq [n first-numbers-less-than-6] (println n))))

;; linq25: TakeWhile - Indexed
(defn linq25 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        first-small-numbers
        (map (fn [[i num]] num)
             (take-while (fn [[i num]] (>= num i)) (map-indexed vector numbers)))]
    (println "First numbers not less than their position:")
  (doseq [n first-small-numbers] (println n))))

;; linq26: SkipWhile - Simple
(defn linq26 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        all-but-first-3-numbers (drop-while #(not= (mod % 3) 0) numbers)]
    (println "All elements starting from first element divisible by 3:")
    (doseq [n all-but-first-3-numbers] (println n))))

;; linq27: SkipWhile - Indexed
(defn linq27 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        later-numbers
        (map (fn [[i num]] num)
             (drop-while (fn [[i num]] (>= num i)) (map-indexed vector numbers)))]
    (println "All elements starting from first element less than its position:")
    (doseq [n later-numbers] (println n))))


(def examples [linq20 linq21 linq22 linq23 linq24 linq25 linq26 linq27])
