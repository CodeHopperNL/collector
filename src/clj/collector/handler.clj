(ns collector.handler
  "Functions to process incoming HTTP requests"
  (:require [hiccup.page :as html]       ; HTML generation
            [compojure.core :refer :all] ; HTTP routing
            [compojure.route :as route]  ; standard HTTP routes

            [clojure.tools.logging :as log]))

(defn landing-page [_]
  (html/html5
   [:head
    [:title "Email collector"]
    (html/include-css "/css/style.css")
    (html/include-js "/cljs/app.js")]
   [:body
    [:div#app
     [:h1 "Email collector"]]]))

(defroutes collector-routes
  ;; route matches are tried in order, first the page:
  (GET "/" request (landing-page request))

  ;; then static resources:
  (route/resources "/")

  ;; otherwise we didn't find it:
  (route/not-found "<h1>Page not found</h1>"))

(def collector-dev collector-routes)
