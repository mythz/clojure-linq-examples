(ns clj-linq.linq-generationoperators
  (:require [clj-linq.data :refer :all]))

;; linq65: Range
(defn linq65 []

  (def numbers (map #(hash-map
                     :number %,
                     :odd-even (if (= (mod % 2) 1) "odd" "even"))
                    (range 100 151)))

  (doall (map #(println "The number" (:number %) "is" (:odd-even %)) numbers))
)

;; linq66: Repeat
(defn linq66 []
  (def numbers (repeat 10 7))
  (doall (map println numbers))
)

(def examples [linq65 linq66])
