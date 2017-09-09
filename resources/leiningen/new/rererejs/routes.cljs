(ns {{name}}.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as rf]
            [{{name}}.utils :refer [uri->query-params
                                     uri->path]]))

(def app-routes
  [true :any-page])

(defn set-page! [match]
  (js/console.log "match" match)
  (rf/dispatch [:set-route match]))

(def history
  (pushy/pushy
    set-page!
    (fn [uri]
      (let [result ((partial bidi/match-route app-routes) uri)]
        (merge
          result
          {:path (uri->path uri)
           :query-params (uri->query-params uri)})))))

(defn start []
  (pushy/start! history))
