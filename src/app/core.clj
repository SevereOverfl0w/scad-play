(ns app.core
  (:refer-clojure :exclude [import use])
  (:require [com.stuartsierra.component :as component]
            [clojure.java.io :as io]
            [scad-clj.scad :refer :all]
            [scad-clj.model :refer :all]))

(def primitives
  (union
    (cube 100 100 100)
    (->> (cube 100 200 100)
         (translate [0 150 0])
         (color [0 0 1]))
    (->> (cylinder 20 100)
         (translate [-100 150 0])
         (rotatev 90 [0 1 0]))))

(defrecord Output [filename data]
  component/Lifecycle
  (start [{:keys [out-file] :as this}]
    (if-not out-file
      (let [out-file (io/file "target/" filename)]
        (spit out-file data)
        (assoc this :out-file out-file))
      this))

  (stop [{:keys [out-file] :as this}]
    (when out-file
      (.delete out-file))
    (:dissoc this :out-file)))

(defn new-system
  []
  (component/system-map
    :output (->Output "demo.scad" (write-scad primitives))))
