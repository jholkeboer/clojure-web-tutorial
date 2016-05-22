(ns clojure-web-tutorial.pages
  (:gen-class)
  (:use hiccup.core
        hiccup.page))

(defn header
  "Head tag for each page"
  [page-title]
  [:head
    [:title page-title]
    (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")])


(defn intro-page
  "Landing page for the tutorial."
  []
  (html
    (header "Introductory Tutorial for Simple Clojure Web Development")
    [:body
      [:div {:class "container"}
        [:h1 "Simple Clojure Web Development Tutorial"]
        [:br]

        [:h2 "Step 1: Background and Setup"]
        [:br]]]))
