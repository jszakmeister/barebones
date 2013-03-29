(ns barebones.core
  (:use [clojure.tools.cli :only [cli]])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (let [[options args banner] (cli ["--faux" "bar"]
                                   ["-h" "--help" "Show help" :default false :flag true]
                                   ["-f" "--faux" "The faux du fafa"])]
    (when (:help options)
      (println banner)
      (System/exit 0))
    (println options))
  (println "Hello, World!"))
