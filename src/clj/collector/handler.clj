(ns collector.handler
  "Functions to process incoming HTTP requests"
  (:require [hiccup.page :as html]        ; HTML generation
            [compojure.core :refer :all]  ; HTTP routing
            [compojure.route :as route]   ; standard HTTP routes
            [ring.util.response :as resp] ; convenience functions for http responses

            [clojure.tools.logging :as log]))

(defn- render-page []
  (html/html5
   [:head
    [:title "Email collector"]
    (html/include-css "/css/styles.css")
    (html/include-js "/cljs-out/dev-main.js")]
   [:body
    [:div#app
     [:h1 "Email collector"]]
    [:script {:type "text/javascript"} "collector.client.mount_root();"]]))

(defn landing-page [_]
  (render-page))

(defn thank-you [_]
  (render-page))

(defn collect-email [_]
  ;; TODO: do something here!
  (resp/redirect "/thanks"))

(defroutes collector-routes
  ;; route matches are tried in order, first the pages:
  (GET "/" request (landing-page request))
  (GET "/thanks" request (thank-you request))

  ;; then actions:
  (POST "/collect" request collect-email)

  ;; then static resources:
  (route/resources "/")

  ;; otherwise we didn't find it:
  (route/not-found "<h1>Page not found</h1>"))

(def collector-dev collector-routes)
