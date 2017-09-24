(ns {{name}}.server
  (:require [compojure
             [core :refer :all]
             [route :as route]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [resource-response]]))

(defroutes app-routes
  (route/resources "/")
  (GET "/*" [] (resource-response "index.html" {:root "public"})))

(def app
  app-routes)
