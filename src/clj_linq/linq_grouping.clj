(ns clj-linq.linq-grouping
  (:require [clj-linq.data :refer :all]
            [clj-time.core :as time]))

(defn anagram-comparer [a b] (compare (sort (.toCharArray a)) (sort (.toCharArray b))))

;; linq40: GroupBy - Simple 1
(defn linq40 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        number-groups (for [g (group-by #(mod % 5) numbers)]
                        {:remainder (first g), :numbers (second g)})]
    (doseq [g number-groups]
      (println "Numbers with a remainder of" (:remainder g) "when divided by 5:")
      (doall (map println (:numbers g))))))

;; linq41: GroupBy - Simple 2
(defn linq41 []
  (let [words ["blueberry" "chimpanzee" "abacus" "banana" "apple" "cheese"]
        word-groups (for [g (group-by #(get % 0) words)]
                      {:first-letter (g 0), :words (g 1)})]
    (doseq [g word-groups]
      (println "Words that start with the letter: " (:first-letter g))
      (doall (map println (:words g))))))

;; linq42: GroupBy - Simple 3
(defn linq42 []
  (let [products products-list
        order-groups (for [g (group-by #(:category %) products)]
                       {:category (first g), :products (second g)})]
    (doseq [x order-groups] (println x))))

;; linq43: GroupBy - Nested
(defn linq43 []
  (let [customers customers-list
        customer-order-groups
        (for [c customers]
          {:company-name (:company-name c),
           :year-groups
           (for [yg (group-by #(time/year (:order-date %)) (:orders c))]
             {:year (first yg)
              :month-groups
              (for [mg (group-by #(:order-date %) (second yg))]
                {:month (time/month (first mg)), :orders (second mg)})})})]
    (doseq [x customer-order-groups] (println x))))

;; linq44: GroupBy - Comparer
(defn linq44 []
  (let [anagrams ["from   " " salt" " earn " "  last   " " near " " form  "]
        order-groups (group-by #(sort (.toCharArray (.trim %))) anagrams)]
    (doseq [x order-groups] (println (second x)))))

;; linq45: GroupBy - Comparer, Mapped
(defn linq45 []
  (let [anagrams ["from   " " salt" " earn " "  last   " " near " " form  "]
        order-groups (group-by #(sort (.toCharArray (.trim %))) (map #(.toUpperCase %) anagrams))]
    (doseq [x order-groups] (println (second x)))))

(def examples [linq40 linq41 linq42 linq43 linq44 linq45])
