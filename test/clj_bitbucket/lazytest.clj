(ns coopquo.lazytest
  (:use lazytest.results
        lazytest.tracker
        lazytest.runner.console
        lazytest.report.nested
        [clojure.java.io :only (file)]))


(comment
  This test is designed to be eval'd via Nailgun/VimClojure
  
  This is nearly an exact copy of lazytest.main.)

(defn test-coopquo []
  (let [namespaces ((tracker (map file ["./test"]) 0))]
    (apply require namespaces)
    (let [results (apply run-tests namespaces)]
      (report results))))

(test-coopquo)

