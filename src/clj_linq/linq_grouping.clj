(ns clj-linq.linq-grouping
  (:require [clj-linq.data :refer :all]
            [clj-time.core :as time]))


;; linq40: GroupBy - Simple 1
(defn linq40 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])
  (def number-groups (map #(hash-map :remainder (% 0), :numbers (% 1))
                          (group-by #(mod % 5) numbers)))

  (doseq [g number-groups]
    (println "Numbers with a remainder of" (:remainder g) "when divided by 5:")
    (doall (map println (:numbers g))))
)

;; linq41: GroupBy - Simple 2
(defn linq41 []
  (def words ["blueberry" "chimpanzee" "abacus" "banana" "apple" "cheese"])
  (def word-groups (map #(hash-map :first-letter (% 0), :words (% 1))
                          (group-by #(get % 0) words)))

  (doseq [g word-groups]
    (println "Words that start with the letter: " (:first-letter g))
    (doall (map println (:words g))))
)

;; linq42: GroupBy - Simple 3
(defn linq42 []
  (def products products-list)
  (def order-groups (map #(hash-map :category (% 0), :products (% 1))
                          (group-by #(:category %) products)))

  (doall (map println order-groups))
)

;; linq43: GroupBy - Nested
(defn linq43 []
  (def customers customers-list)
  (def customer-order-groups
    (map #(hash-map
           :company-name (:company-name %),
           :year-groups
           (map (fn [yg]
                  (hash-map :year (get yg 0)
                            :month-groups
                            (map (fn [mg] {:month (time/month (get mg 0)), :orders (get mg 1)})
                                 (group-by (fn [o] (:order-date o)) (get yg 1)))
                            ))
                (group-by (fn [o] (:year o)) (:orders %)))
           )
     customers))

  (doall (map println customer-order-groups))
)

(defn anagram-comparer [a b] (compare (sort (.toCharArray a)) (sort (.toCharArray b))))

;; linq44: GroupBy - Comparer
(defn linq44 []
  (def anagrams ["from   " " salt" " earn " "  last   " " near " " form  "])
  (def order-groups (group-by #(sort (.toCharArray (.trim %))) anagrams))

  (doall (map #(println (get % 1)) order-groups))
)

;; linq45: GroupBy - Comparer, Mapped
(defn linq45 []
  (def anagrams ["from   " " salt" " earn " "  last   " " near " " form  "])
  (def order-groups (group-by #(sort (.toCharArray (.trim %))) (map #(.toUpperCase %) anagrams)))

  (doall (map #(println (get % 1)) order-groups))
)

(def examples [linq40 linq41 linq42 linq43 linq44 linq45])
