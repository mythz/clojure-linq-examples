(ns clj-linq.linq-generationoperators
  (:require [clj-linq.data :refer :all]))

;; linq65: Range
(defn linq65 []
  (let [numbers (for [n (range 100 151)]
                  {:number n,
                   :odd-even (if (= (mod n 2) 1) "odd" "even")})]
    (doseq [n numbers] (println "The number" (:number n) "is" (:odd-even n)))))

;; linq66: Repeat
(defn linq66 []
  (let [numbers (repeat 10 7)]
    (doseq [n numbers] (println n))))

(def examples [linq65 linq66])
