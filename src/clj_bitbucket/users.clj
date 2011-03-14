(ns
  ^{:doc "BitBucket Users API features
  [http://confluence.atlassian.com/display/BBDEV/Users]
         
  This also includes the events and followers RESTful calls associated with users"
    :author "[Paul deGrandis](https://github.com/ohpauleez)"}
  clj-bitbucket.users
  (:require [clj-bitbucket.core :as core]))


(defn fetch-user
  ""
  ([username]
   (fetch-user username {}))
  ([username {:keys [auth ret-format] :or {auth {} ret-format "json"} :as opts}]
   (core/make-json-request
     (core/create-request :get
                          (str "/users/" username)
                          opts
                          ret-format)
     auth)))

(defn create-user
  ""
  [])


;; User events
;; =================
(defn fetch-user-events
  ""
  ([username]
   (fetch-user-events username {}))
  ([username opts]
   (fetch-user (str username "/events") opts)))


;; User followers
;; =================
(defn fetch-user-followers
  ""
  ([username]
   (fetch-user-followers username {}))
  ([username opts]
   (fetch-user (str username "/followers") opts)))

