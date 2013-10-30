(ns clj-linq.core
  (:require [clj-linq.data :refer :all]
            [clj-linq.linq-restrictions        :as restrictions]
            [clj-linq.linq-projections         :as projections]
            [clj-linq.linq-partitioning        :as partitioning]
            [clj-linq.linq-ordering            :as ordering]
            [clj-linq.linq-grouping            :as grouping]
            [clj-linq.linq-setoperators        :as setoperators]
            [clj-linq.linq-conversions         :as conversions]
            [clj-linq.linq-elementoperators    :as elementoperators]
            [clj-linq.linq-generationoperators :as generationoperators]
            [clj-linq.linq-quantifiers         :as quantifiers]
            [clj-linq.linq-aggregateoperators  :as aggregateoperators]
            [clj-linq.linq-miscoperators       :as miscoperators]
            [clj-linq.linq-queryexecution      :as queryexecution]
            [clj-linq.linq-joinoperators       :as joinoperators]))

(defn run-examples [examples]
  (doseq [f examples] (prn) (f)))

(defn -main [& args]
  (run-examples restrictions/examples)
  (run-examples projections/examples)
  (run-examples partitioning/examples)
  (run-examples ordering/examples)
  (run-examples grouping/examples)
  (run-examples setoperators/examples)
  (run-examples conversions/examples)
  (run-examples elementoperators/examples)
  (run-examples generationoperators/examples)
  (run-examples quantifiers/examples)
  (run-examples aggregateoperators/examples)
  (run-examples miscoperators/examples)
  (run-examples queryexecution/examples)
  (run-examples joinoperators/examples)
)




































