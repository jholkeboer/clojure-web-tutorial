(ns clojure-web-tutorial.core
  (:gen-class)
  (:use hiccup.core)
  (:require
    [ring.adapter.jetty :as jetty]
    [compojure.core :refer :all]
    [compojure.route :as route]))

(defroutes app-routes
  "Defines handling for each route"
  (GET "/" [] (html [:h1 "It's working!"]))
  (GET "/name/:myname" [myname] (html [:h2 (str "Your name is " myname ".")]))
  (route/not-found "404 Page not found."))

(defn -main
  "This function runs the Jetty web server and handles requests."
  [& args]
  (jetty/run-jetty
    app-routes
    {:port 5000}))
