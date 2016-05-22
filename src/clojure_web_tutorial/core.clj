(ns clojure-web-tutorial.core
  (:gen-class)
  (:use hiccup.core)
  (:require
    [ring.adapter.jetty :as jetty]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure-web-tutorial.pages :as pages]))

(defn get-page
  [pagenumber]
  (cond
    (= pagenumber "1")
    (pages/intro-page)

    (= pagenumber "2")
    (html "")

    (= pagenumber "3")
    (html "")

    (= pagenumber "4")
    (html "")

    (= pagenumber "5")
    (html "")

    :else
    (html (html [:h1 "Page not found."]))))


(defroutes app-routes
  "Defines handling for each route"
  (GET "/" [] (get-page "1"))
  (GET "/pages/:page-number" [page-number] (get-page page-number))
  (route/not-found "404 Page not found."))

(defn -main
  "This function runs the Jetty web server and handles requests."
  [& args]
  (jetty/run-jetty
    app-routes
    {:port 5000}))
