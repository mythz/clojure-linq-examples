(ns clj-linq.linq-joinoperators
  (:require [clj-linq.data :refer :all]))

(defn join [coll with-coll matcher]
  (map (fn [x]
         {:key x :items (filter (fn [y] (matcher x y)) with-coll)})
       coll))

;; linq102: Cross Join
(defn linq102 []
  (def categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"])

  (def products products-list)

  (def q
    (flatten (map
     (fn [pc] (map #(identity {:category (:key pc), :product-name (:product-name %)})
                   (:items pc)))
     (join categories products #(= %1 (:category %2)))))
    )

  (doall (map println q))
)

;; linq103: Group Join
(defn linq103[]

  (def categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"])

  (def products products-list)

  (def q (map #(identity {:category (:key %), :products (:items %)})
     (join categories products #(= %1 (:category %2)))))

  (doseq [pc q]
    (println (:category pc))
    (doseq [product (:products pc)]
      (println " " (:product-name product))
    ))
)

;; linq104: Cross Join with Group Join
(defn linq104[]

  (def categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"])

  (def products products-list)

  (def q
    (flatten (map
     (fn [pc] (map #(identity {:category (:key pc), :product-name (:product-name %)})
                   (:items pc)))
     (join categories products #(= %1 (:category %2)))))
    )

  (doseq [p q]
    (println (:product-name p) ":" (:category p)))
)

;; linq105: Left Outer Join
(defn linq105[]

  (def categories ["Beverages", "Condiments", "Vegetables", "Dairy Products", "Seafood"])

  (def products products-list)

  (def q
    (flatten
     (map (fn [pc]
            (if (empty? (:items pc))
              {:category (:key pc), :product-name "(No products)"}
              (map #(identity {:category (:key pc), :product-name (:product-name %)})
                   (:items pc))))
          (join categories products #(= %1 (:category %2))))))

  (doseq [p q]
    (println (:product-name p) ":" (:category p)))
)

(def examples [linq102 linq103 linq105])
