(defproject org.clojars.ohpauleez/clj-bitbucket "0.1.0-SNAPSHOT"
  :description "BitBucket API bindings for Clojure"
  :url "http://github.com/ohpauleez/clj-bitbucket"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "See the notice in README.md or details in LICENSE.html"}
  :dependencies [;[org.clojure/clojure "1.3.0-master-SNAPSHOT"]
                 [org.clojure/clojure "1.2.0"]
                 [clj-http "0.1.3"]
                 [clj-json "0.3.1"]]
  :dev-dependencies [[vimclojure/server "2.3.0-SNAPSHOT"]
                     [org.clojure/clojure-contrib "1.2.0"]
                     [org.clojure/clojure "1.3.0-alpha4"]
                     [org.clojure.contrib/repl-utils "1.3.0-alpha4"]
                     ;[org.clojure.contrib/repl-utils "1.3.0-SNAPSHOT"]
                     [lein-cdt "1.0.0"]
                     [marginalia "0.5.0"]
                     ;[lein-multi "1.0.0"]
                     [com.stuartsierra/lazytest "2.0.0-SNAPSHOT"]]
  :repositories {"stuartsierra-releases" "http://stuartsierra.com/maven2"
                 "stuartsierra-snapshots" "http://stuartsierra.com/m2snapshots"}
  :hooks  [leiningen.hooks.cdt]
  ;:warn-on-reflection true
  ;:jvm-opts ["-Xmx1g"]
  :repl-init-script "script/repl_init.clj")

