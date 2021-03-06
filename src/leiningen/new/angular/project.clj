(defproject {{ns-name}} "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [lib-noir "0.8.1"]
                 [compojure "1.1.6"]
                 [ring-server "0.3.1"]
                 [selmer "0.6.5"]
                 [com.taoensso/timbre "3.1.6"]
                 [com.postspectacular/rotor "0.1.0"]
                 [com.taoensso/tower "2.0.2"]
                 [markdown-clj "0.9.40"]
                 [liberator "0.11.0"]
                 [clj-time "0.6.0"]
                 [environ "0.4.0"]]

  :aot :all
  :repl-options {:init-ns {{ns-name}}.repl}

  :plugins [[lein-ring "0.8.7"]
            [lein-environ "0.4.0"]]

  :ring {:handler {{ns-name}}.handler/app
         :init    {{ns-name}}.handler/init
         :destroy {{ns-name}}.handler/destroy}

  :profiles
  {:production
   {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}
    :env {:selmer-dev false}}

   :dev
   {:dependencies [[ring-mock "0.1.5"]
                    [ring/ring-devel "1.2.2"]]
    :env {:selmer-dev true}}

   :testing
   {:dependencies [[ring-mock "0.1.5"]
                   [ring/ring-devel "1.2.2"]]
    :env {:selmer-dev true}}}

  :min-lein-version "2.0.0")
