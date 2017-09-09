(ns {{name}}.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :get
 (fn [db [_ path]]
   (js/console.log :get path)
   (let [path (if (sequential? path) path [path])]
     (get-in db path))))
