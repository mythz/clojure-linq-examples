(ns clj-linq.linq-joinoperators
  (:require [clj-linq.data :refer :all]))

(defn join-group [coll with-coll matcher]
  (map (fn [x] {:key x :items (filter (fn [y] (matcher x y)) with-coll)})
       coll))

;; linq102: Cross Join
(defn linq102 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten
           (for [pc (join-group categories products #(= %1 (:category %2)))]
             (for [x (:items pc)]
               {:category (:key pc), :product-name (:product-name x)})))]
    (doseq [v q]
      (println (:product-name v) ":" (:category v)))))

;; linq103: Group Join
(defn linq103 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (for [pc (join-group categories products #(= %1 (:category %2)))]
            {:category (:key pc), :products (:items pc)})]
    (doseq [pc q]
      (println (:category pc))
      (doseq [product (:products pc)]
        (println " " (:product-name product))))))

;; linq104: Cross Join with Group Join
(defn linq104 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten
           (for [pc (join-group categories products #(= %1 (:category %2)))]
             (for [p (:items pc)]
               {:category (:key pc),
                :product-name (:product-name p)})))]
    (doseq [p q]
    (println (:product-name p) ":" (:category p)))))

;; linq105: Left Outer Join
(defn linq105 []
  (let [categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"]
        products products-list
        q (flatten
           (for [pc (join-group categories products #(= %1 (:category %2)))]
             (if (empty? (:items pc))
               {:category (:key pc), :product-name "(No products)"}
               (for [p (:items pc)]
                 {:category (:key pc),
                  :product-name (:product-name p)}))))]
    (doseq [p q]
      (println (:product-name p) ":" (:category p)))))


(def examples [linq102 linq103 linq105])
