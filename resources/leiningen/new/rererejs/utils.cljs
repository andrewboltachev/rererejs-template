(ns {{name}}.utils)

(defn uri->path [uri]
  ; "?a=1&&b=&c=2" -> {"a" ["1"], "" [""], "b" [""], "c" ["2"]}
  (.getPath (goog.Uri.parse uri)))

(defn uri->query-params [uri]
  ; "?a=1&&b=&c=2" -> {"a" ["1"], "" [""], "b" [""], "c" ["2"]}
  (let [query-data (.getQueryData (goog.Uri.parse uri)) ks (js->clj (.getKeys query-data))] (into {} (map #(do [% (js->clj (.getValues query-data %))])) ks)))

(defn query-params->query-string [query-params]
  ; {"a" ["1"], "" [""], "b" [""], "c" ["2"]} -> "?a=1&&b=&c=2"
  (str "?" (.toString (goog.Uri.QueryData.createFromMap (clj->js query-params)))))
