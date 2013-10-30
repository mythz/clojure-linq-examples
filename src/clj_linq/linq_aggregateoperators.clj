(ns clj-linq.linq-aggregateoperators
  (:require [clj-linq.data :refer :all]))

(defn average [coll] (/ (reduce + coll) (count coll)))

;; linq73: Count - Simple
(defn linq73 []
  (def factors-of-300 [2 2 3 5 5])

  (def unique-factors (count (distinct factors-of-300)))

  (println "There are" unique-factors "unique factors of 300.")
)

;; linq74: Count - Conditional
(defn linq74 []
  (def numbers [4 5 1 3 9 0 6 7 2 0])

  (def odd-numbers (count (filter #(= 1 (mod % 2)) numbers)))

  (println "There are" odd-numbers "odd numbers in the list.")
)

;; linq76: Count - Nested
(defn linq76 []
  (def customers customers-list)

  (def order-counts (map #(hash-map :customer-id (:customer-id %)
                                    :order-count (count (:orders %)))
                         customers))

  (doall (map println order-counts))
)

;; linq77: Count - Grouped
(defn linq77 []

  (def products products-list)

  (def category-counts
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :product-count (count (get % 1))))))

  (doall (map println category-counts))
)

;; linq78: Sum - Simple
(defn linq78 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def num-sum (reduce + numbers))

  (println "The sum of the numbers is " num-sum)
)

;; linq79: Sum - Projection
(defn linq79 []
  (def words ["cherry", "apple", "blueberry"])

  (def total-chars (reduce + (map count words)))

  (println "There are a total of" total-chars "characters in these words.")
)

;; linq80: Sum - Grouped
(defn linq80 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :total-units-in-stock (reduce + (map :units-in-stock (get % 1)))))))

  (doall (map println categories))
)

;; linq81: Min - Simple
(defn linq81 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def min-num (apply min numbers))

  (println "The minimum number is" min-num)
)

;; linq82: Min - Projection
(defn linq82 []
  (def words ["cherry", "apple", "blueberry"])

  (def shortest-word (apply min (map count words)))

  (println "The shortest word is" shortest-word "characters long.")
)

;; linq83: Min - Grouped
(defn linq83 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :cheapest-price (apply min (map :unit-price (get % 1)))))))

  (doall (map println categories))
)

;; linq84: Min - Elements
(defn linq84 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map (fn [g]
           (let [min-price (apply min (map :unit-price (get g 1)))]
             (hash-map
              :category (get g 0)
              :cheapest-products
              (filter #(= (:unit-price %) min-price)
                      (get g 1))
              )
             )))
         ))

  (doall (map println categories))
)

;; linq85: Max - Simple
(defn linq85 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def max-num (apply max numbers))

  (println "The maximum number is" max-num)
)

;; linq86: Max - Projection
(defn linq86 []
  (def words ["cherry", "apple", "blueberry"])

  (def longest-word (apply max (map count words)))

  (println "The longest word is" longest-word "characters long.")
)

;; linq87: Max - Grouped
(defn linq87 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :most-expensive-price (apply max (map :unit-price (get % 1)))))))

  (doall (map println categories))
)

;; linq88: Max - Elements
(defn linq88 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map (fn [g]
           (let [max-price (apply max (map :unit-price (get g 1)))]
             (hash-map
              :category (get g 0)
              :most-expensive-products
              (filter #(= (:unit-price %) max-price)
                      (get g 1))
              )
             )))
         ))

  (doall (map println categories))
)

;; linq89: Average - Simple
(defn linq89 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def avg (average numbers))

  (println "The average number is" avg)
)

;; linq90: Average - Projection
(defn linq90 []
  (def words ["cherry", "apple", "blueberry"])

  (def average-length (average (map count words)))

  (println "The average word length is" average-length "characters.")
)

;; linq91: Average - Grouped
(defn linq91 []
  (def products products-list)

  (def categories
    (->> products
         (group-by :category)
         (map #(hash-map :category (get % 0),
                         :average-price (average (map :unit-price (get % 1)))))))

  (doall (map println categories))
)

;; linq92: Aggregate - Simple
(defn linq92 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])

  (def product (reduce * dbls))

  (println "Total product of all numbers:" product)
)

;; linq93: Aggregate - Seed
(defn linq93 []
  (def start-balance 100)
  (def attempted-withdrawls [20 10 40 50 10 70 30])

  (def end-balance (reduce #(identity (if (<= %2 %1) (- %1 %2) %1))
                           start-balance attempted-withdrawls))

  (println "Ending balance:" end-balance)
)

(def examples [linq73 linq74 linq76 linq77 linq78 linq79 linq80 linq81 linq82 linq83
               linq84 linq85 linq86 linq87 linq88 linq89 linq90 linq91 linq92 linq93])


