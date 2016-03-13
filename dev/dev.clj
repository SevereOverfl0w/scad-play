(ns dev
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.namespace.repl :refer (refresh)]
            [clojure.stacktrace :refer [print-stack-trace]]
            [app.core :as app]))

(def system nil)

(defn init []
  (alter-var-root #'system
    (constantly (app/new-system))))

(defn start []
  (try
    (alter-var-root #'system component/start)
    (catch Exception e
      (print-stack-trace e))))

(defn stop []
  (alter-var-root #'system
    (fn [s] (when s (component/stop s)))))

(defn go []
  (init)
  (start))

(defn reset []
  (stop)
  (refresh :after 'dev/go))
