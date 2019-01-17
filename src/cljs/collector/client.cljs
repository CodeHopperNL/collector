(ns collector.client
  (:require [reagent.core :as r]))

(defn root-component []
  [:div [:h1 "Enter your data:"]
   [:form {:action "/collect" :method "POST"}
    [:div#form
     [:label {:for "name"} "Name:"]
     [:input {:type "name" :name "name" :id "name"}]

     [:label {:for "email"} "Email:"]
     [:input {:type "email" :name "email" :id "email"}]

     [:button "Submit"]]]])

(defn ^:export mount-root []
  (r/render [root-component]
            (.getElementById js/document "app")))
