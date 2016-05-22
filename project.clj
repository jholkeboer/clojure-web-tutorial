(defproject clojure-web-tutorial "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.0"]
                 [ring "1.4.0"]
                 [hiccup "1.0.5"]
                 [environ "1.0.3"]]

  :main ^:skip-aot clojure-web-tutorial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
