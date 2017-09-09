(ns leiningen.new.rererejs
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "rererejs"))

(defn rererejs
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' rererejs project.")
    (->files data
             ["resources/public/index.html" (render "index.html" data)]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/cljsjs/react.cljs" (render "react.cljs" data)]
             ["src/cljsjs/react/dom.cljs" (render "dom.cljs" data)]
             ["src/{{sanitized}}/config.cljs" (render "config.cljs" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/{{sanitized}}/db.cljs" (render "db.cljs" data)]
             ["src/{{sanitized}}/events.cljs" (render "events.cljs" data)]
             ["src/{{sanitized}}/routes.cljs" (render "routes.cljs" data)]
             ["src/{{sanitized}}/subs.cljs" (render "subs.cljs" data)]
             ["src/{{sanitized}}/utils.cljs" (render "utils.cljs" data)]
             ["src/{{sanitized}}/views.cljs" (render "views.cljs" data)]
             ["gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["package.json" (render "package.json" data)]
             ["project.clj" (render "project.clj" data)]
             ["webpack.config.js" (render "webpack.config.js" data)]
             ["webpack.entry.js" (render "webpack.entry.js" data)]
             ["yarn.lock" (render "yarn.lock" data)]
             )))
