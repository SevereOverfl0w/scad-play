(ns dev
  (:require [com.stuartsierra.component :as component]
            [reloaded.repl :refer [system init start stop go reset reset-all]]
            [app.core :as app]))

(reloaded.repl/set-init! app/new-system)
