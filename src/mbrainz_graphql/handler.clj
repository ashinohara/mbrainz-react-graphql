(ns mbrainz-graphql.handler
  (:use [ring.middleware.json :only [wrap-json-body]])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :refer :all]
            [clojure.walk :refer [keywordize-keys]]
            [graphql-parser.example :refer [graphql-query]]))

(defn post-graphql [request]
  (println request)
  (let [body (keywordize-keys (:form-params request))
        query (:query body)
        results (graphql-query query)]
    (println "QUerying" query results)
    {:status 200
     :headers {"Content-type" "application/json"}
     :body (generate-string results)}))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/index.html"))
  (POST "/graphql" {params :params} (wrap-json-body post-graphql))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
