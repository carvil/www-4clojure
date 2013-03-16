(defproject www-4clojure "0.1.0-SNAPSHOT"
  :description "Exercises from www.4clojure.com"
  :url "http://www.4clojure.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :repositories {
    "stuart" "http://stuartsierra.com/maven2"
    "conjars" "http://conjars.org/repo"}
  :profiles {:dev
            {:plugins      [[lein-midje "3.0.0"]]
             :dependencies [[midje "1.5.0"]
                            [com.stuartsierra/lazytest "1.2.3"]]}})
