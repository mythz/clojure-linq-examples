(ns clj-linq.linq-conversions
  (:require [clj-linq.data :refer :all]))

;; linq54: ToArray
(defn linq54 []
  (let [dbls [1.7 2.3 1.9 4.1 2.9]
        sorted-doubles (->> dbls sort reverse)]
    (println "Every other double from highest to lowest:")
    (doseq [d (take-nth 2 sorted-doubles)] (println d))))

;;linq55: ToList
(defn linq55 []
  (let [words ["cherry", "apple", "blueberry"]
        sorted-words (->> words
                          sort
                          (apply list))]
    (println "The sorted word list:")
    (doseq [w sorted-words] (println w))))

;;linq56: ToDictionary
(defn linq56 []
  (let [sorted-records [{:name "Alice", :score 50}
                        {:name "Bob", :score 40}
                        {:name "Cathy", :score 45}]
        sorted-records-dict (->> sorted-records
                                 (map #(hash-map (:name %) (:score %)))
                                 (into {}))]
    (println "Bob's score:" (sorted-records-dict "Bob"))))

;; linq57: OfType
(defn linq57 []
  (let [numbers [nil 1.0 "two" 3 "four" 5 "six" 7.0]
        dbls (filter #(= (type %) java.lang.Double) numbers)]
    (println "Numbers stored as doubles:")
    (doseq [d dbls] (println d))))

(def examples [linq54 linq55 linq56 linq57])
