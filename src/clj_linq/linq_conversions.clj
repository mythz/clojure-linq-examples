(ns clj-linq.linq-conversions
  (:require [clj-linq.data :refer :all]))

;; linq54: ToArray
(defn linq54 []
  (def dbls [1.7 2.3 1.9 4.1 2.9])
  (def sorted-doubles (->> dbls sort reverse))

  (println "Every other double from highest to lowest:")
  (doall (map println (take-nth 2 sorted-doubles)))
)

;;linq55: ToList
(defn linq55 []
  (def words ["cherry", "apple", "blueberry"])
  (def sorted-words (->> words
                         sort
                         (apply list)))

  (println "The sorted word list:")
  (doall (map println sorted-words))
)

;;linq56: ToDictionary
(defn linq56 []
  (def sorted-records [{:name "Alice", :score 50}
                       {:name "Bob", :score 40}
                       {:name "Cathy", :score 45}])

  (def sorted-records-dict (->> sorted-records
                                (map #(hash-map (:name %) (:score %)))
                                (into {})))
  (println "Bob's score:" (sorted-records-dict "Bob"))
)

;; linq57: OfType
(defn linq57 []
  (def numbers [nil 1.0 "two" 3 "four" 5 "six" 7.0])

  (def dbls (filter #(= (type %) java.lang.Double) numbers))

  (println "Numbers stored as doubles:")
  (doall (map println dbls))
)

(def examples [linq54 linq55 linq56 linq57])
