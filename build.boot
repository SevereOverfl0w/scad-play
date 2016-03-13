(set-env!
  :dependencies '[[org.clojure/tools.namespace "0.3.0-alpha3"]
                  [com.stuartsierra/component "0.3.1"]
                  [scad-clj "0.5.1"]
                  [reloaded.repl "0.2.1"]]
  :source-paths #{"src" "dev"}
  :resource-paths #{"resources"})

(deftask dev
  []
  (repl :init-ns 'dev))
