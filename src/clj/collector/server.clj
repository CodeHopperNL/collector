(ns collector.server
  (:require [ring.adapter.jetty :as jetty]
            [collector.handler :as handler]))

(defonce server (atom nil))

(defn start! []
  (if @server
    (do (println "server already started")
        @server)
    (reset! server (jetty/run-jetty handler/collector-dev {:port  3000
                                                           :join? false}))))

(defn stop! []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn -main []
  (start!))
