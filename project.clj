(defproject mbrainz-graphql "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-json "0.3.1"]
                 [cheshire "5.4.0"]
                 [graphql-parser "0.1.0-SNAPSHOT"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler mbrainz-graphql.handler/app}
  :jvm-opts ["-Xmx1g" "-server"]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
