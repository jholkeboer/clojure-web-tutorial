(ns clojure-web-tutorial.core
  (:gen-class)
  (:use hiccup.core)
  (:require
    [ring.adapter.jetty :as jetty]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure-web-tutorial.pages :as pages]))


(defroutes app-routes
  "Defines handling for each route"
  (GET "/" [] (pages/get-page "1"))
  (GET "/pages/:pagenumber" [pagenumber] (pages/get-page pagenumber))
  (route/not-found "404 Page not found."))

(defn -main
  "This function runs the Jetty web server and handles requests."
  [& args]
  (jetty/run-jetty
    app-routes
    {:port 5000}))
