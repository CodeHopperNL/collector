(ns collector.handler
  (:require [hiccup.page :as html]
            [clojure.tools.logging :as log]))

(defn landing-page []
  (html/html5
   [:head
    [:title "Email collector"]
    (html/include-css "/css/style.css")
    (html/include-js "/cljs/app.js")]
   [:body
    [:div#app
     [:h1 "Email collector"]]]))

(defn collector-dev [_]
  {:status  200
   :headers {"content-type" "text/html"}
   :body    (landing-page)})
