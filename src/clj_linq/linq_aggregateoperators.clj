(ns clj-linq.linq-aggregateoperators
  (:require [clj-linq.data :refer :all]))

(defn average [coll] (/ (reduce + coll) (count coll)))

;; linq73: Count - Simple
(defn linq73 []
  (let [factors-of-300 [2 2 3 5 5]
        unique-factors (count (distinct factors-of-300))]
    (println "There are" unique-factors "unique factors of 300.")))

;; linq74: Count - Conditional
(defn linq74 []
  (let [numbers [4 5 1 3 9 0 6 7 2 0]
        odd-numbers (count (for [n numbers :when (= 1 (mod n 2))] n))]
    (println "There are" odd-numbers "odd numbers in the list.")))

;; linq76: Count - Nested
(defn linq76 []
  (let [customers customers-list
        order-counts
        (for [c customers]
          {:customer-id (:customer-id c) :order-count (count (:orders c))})]
  (doseq [x order-counts] (println x))))

;; linq77: Count - Grouped
(defn linq77 []
  (let [products products-list
        category-counts
        (->> products
             (group-by :category)
             (map #(identity {:category (first %),
                              :product-count (count (second %))})))]
    (doseq [x category-counts] (println x))))

;; linq78: Sum - Simple
(defn linq78 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        num-sum (reduce + numbers)]
    (println "The sum of the numbers is " num-sum)))

;; linq79: Sum - Projection
(defn linq79 []
  (let [words ["cherry", "apple", "blueberry"]
        total-chars (reduce + (map count words))]
    (println "There are a total of" total-chars "characters in these words.")))

;; linq80: Sum - Grouped
(defn linq80 []
  (let [products products-list
        categories
        (->> products
             (group-by :category)
             (map #(identity
                    {:category (get % 0),
                     :total-units-in-stock (reduce + (map :units-in-stock (get % 1)))})))]
    (doseq [x categories] (println x))))

;; linq81: Min - Simple
(defn linq81 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        min-num (apply min numbers)]
    (println "The minimum number is" min-num)))

;; linq82: Min - Projection
(defn linq82 []
  (let [words ["cherry", "apple", "blueberry"]
        shortest-word (apply min (map count words))]
    (println "The shortest word is" shortest-word "characters long.")))

;; linq83: Min - Grouped
(defn linq83 []
  (let [products products-list
        categories
        (->> products
             (group-by :category)
             (map #(identity {:category (first %),
                             :cheapest-price (apply min (map :unit-price (second %)))})))]
    (doseq [c categories] (println c))))

;; linq84: Min - Elements
(defn linq84 []
  (let [products products-list
        categories
        (for [g (group-by :category products)
              :let [min-price (apply min (map :unit-price (second g)))]]
          {:category (first g)
           :cheapest-products (for [p (second g)
                                    :when (= (:unit-price p) min-price)] p)})]
    (doseq [c categories] (println c))))

;; linq85: Max - Simple
(defn linq85 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        max-num (apply max numbers)]
    (println "The maximum number is" max-num)))

;; linq86: Max - Projection
(defn linq86 []
  (let [words ["cherry", "apple", "blueberry"]
        longest-word (apply max (map count words))]
    (println "The longest word is" longest-word "characters long.")))

;; linq87: Max - Grouped
(defn linq87 []
  (let [products products-list
        categories
        (->> products
             (group-by :category)
             (map #(identity
                    {:category (get % 0),
                     :most-expensive-price (apply max (map :unit-price (get % 1)))})))]
    (doseq [c categories] (println c))))

;; linq88: Max - Elements
(defn linq88 []
  (let [products products-list
        categories
        (for [g (group-by :category products)
              :let [max-price (apply max (map :unit-price (second g)))]]
          {:category (first g)
           :most-expensive-products
           (for [p (second g) :when (= (:unit-price p) max-price)] p)})]
    (doseq [c categories] (println c))))

;; linq89: Average - Simple
(defn linq89 []
  (let [numbers [5 4 1 3 9 8 6 7 2 0]
        avg (average numbers)]
    (println "The average number is" avg)))

;; linq90: Average - Projection
(defn linq90 []
  (let [words ["cherry", "apple", "blueberry"]
        average-length (average (map count words))]
    (println "The average word length is" average-length "characters.")))

;; linq91: Average - Grouped
(defn linq91 []
  (let [products products-list
        categories
        (for [g (group-by :category products)]
          {:category (first g),
           :average-price (average (map :unit-price (second g)))})]
    (doseq [c categories] (println c))))

;; linq92: Aggregate - Simple
(defn linq92 []
  (let [dbls [1.7 2.3 1.9 4.1 2.9]
        product (reduce * dbls)]
    (println "Total product of all numbers:" product)))

;; linq93: Aggregate - Seed
(defn linq93 []
  (let [start-balance 100
        attempted-withdrawls [20 10 40 50 10 70 30]
        end-balance (reduce #(identity (if (<= %2 %1) (- %1 %2) %1))
                            start-balance attempted-withdrawls)]
    (println "Ending balance:" end-balance)))

(def examples [linq73 linq74 linq76 linq77 linq78 linq79 linq80 linq81 linq82 linq83
               linq84 linq85 linq86 linq87 linq88 linq89 linq90 linq91 linq92 linq93])


