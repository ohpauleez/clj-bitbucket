(ns
  ^{:doc "BitBucket Repositories API features
  [http://confluence.atlassian.com/display/BBDEV/Repositories]

  This also includes the events and followers RESTful calls associated with repositories"
    :author "[Paul deGrandis](https://github.com/ohpauleez)"}
  clj-bitbucket.repositories
  (:require [clj-bitbucket.core :as core]))


(defn search-repos
  "Search for repositories related to a query
  Arguments:
    query - a string, the subject matter you're trying to find repositories for
    [opts] - a map, extra options to pass to core/create-request or core/create-request, such as :auth
  Returns
     - a map, with the list of repositories at :repositories.  Each repo will be a map."
  ([query]
   (search-repos query {}))
  ([query {:keys [auth ret-format] :or {auth {} ret-format "json"} :as opts}]
   (core/make-json-request
     (core/create-request :get "/repositories/"
                          (assoc-in opts [:query-params :name] query)
                          ret-format)
     auth)))

(defn create-repo
  ""
  [])

(defn fetch-repo
  "Fetch a given repo, optionally passing in an options map for create-request/make-request"
  ([user repo opts]
   (search-repos (str user "/" repo) opts))
  ([userrepo]
   (fetch-repo userrepo {}))
  ([userrepo {:keys [auth ret-format] :or {auth {} ret-format "json"} :as opts}]
   (core/make-json-request
     (core/create-request :get
                          (str "/repositories/" userrepo)
                          opts
                          ret-format)
     auth)))

(defn tags
  "Fetch the tags of a given repo"
  ([user repo opts]
   (tags (str user "/" repo) opts))
  ([userrepo]
   (tags userrepo {}))
  ([userrepo opts]
   (fetch-repo (str userrepo "/tags/") opts)))

(defn branches
  "Fetch the branches of a given repo"
  ([user repo opts]
   (branches (str user "/" repo) opts))
  ([userrepo]
   (branches userrepo {}))
  ([userrepo opts]
   (fetch-repo (str userrepo "/branches/") opts)))

(defn update-repo
  ""
  [])

(defn delete-repo
  ""
  [])


;; Repository events
;; =================
(defn fetch-repo-events
  "Fetch the events of a given repos"
  ([user repo opts]
   (fetch-repo-events (str user "/" repo) opts))
  ([userrepo]
   (fetch-repo-events userrepo {}))
  ([userrepo opts]
   (fetch-repo (str userrepo "/events") opts)))

;; Repository followers
;; ====================
(defn fetch-repo-followers
  "Fetch the followers of a given repos"
  ([user repo opts]
   (fetch-repo-events (str user "/" repo) opts))
  ([userrepo]
   (fetch-repo-events userrepo {}))
  ([userrepo opts]
   (fetch-repo (str userrepo "/followers") opts)))
