(ns clj-bitbucket.repositories
  "BitBucket Repositories API features
  [http://confluence.atlassian.com/display/BBDEV/Repositories]"
  (:require [clj-bitbucket.core :as core]))


(defn search-repos
  [query [{:keys [auth ret-format] :or {:auth {} :format "json"}} opts]]
  (core/make-json-request
    (core/create-request :get "/repositories/"
                         (assoc-in opts [:query-params :name] query)
                         ret-format)))

(defn create-repo)

(defn fetch-repo
  ([user repo opts]
   (search-repos (str user "/" repo) opts))
  ([userrepo [{:keys [auth ret-format] :or {:auth {} :format "json"}} opts]]
   (core/make-json-request
     (core/create-request :get
                          (str "/repositories/" userrepo)
                          opts
                          ret-format)
     auth)))

(defn tags
  ([user repo opts]
   (tags (str user "/" repo) opts))
  ([userrepo opts]
   (fetch-repo (str userrepo "/tags/") opts)))

(defn branches
  ([user repo opts]
   (branches (str user "/" repo) opts))
  ([userrepo opts]
   (fetch-repo (str userrepo "/branches/") opts)))

(defn update-repo)

(defn delete-repo)


