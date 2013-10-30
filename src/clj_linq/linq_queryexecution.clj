(ns clj-linq.linq-queryexecution
  (:require [clj-linq.data :refer :all]))

;; linq99: Deferred Execution
(defn linq99 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def i (atom 0))
  (def q (map (fn [x] (swap! i inc)) (range 10)))

  (println @i (count q) @i)
)

;; linq100: Immediate Execution
(defn linq100 []
  (def numbers [5 4 1 3 9 8 6 7 2 0])

  (def i (atom 0))
  (def q (into [] (map (fn [x] (swap! i inc)) (range 10))))

  (println @i (count q) @i)
)

;; linq101: Query Reuse
(defn linq101 []
  (def ^:dynamic numbers [5 4 1 3 9 8 6 7 2 0])

  (defn low-numbers []
    (filter #(<= % 3) numbers))

  (println "First run numbers <= 3:")
  (doall (map println (low-numbers)))

  (println "Second run numbers <= 3")
  (binding [numbers (map #(* -1 %) numbers)]
    (doall (map println (low-numbers))))
)

(def examples [linq99 linq100 linq101])

