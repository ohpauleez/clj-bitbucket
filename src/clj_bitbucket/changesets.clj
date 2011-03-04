(ns clj-bitbucket.changesets
  "BitBucket Changesets API features
  [http://confluence.atlassian.com/display/BBDEV/Changesets]"
  (:require [clj-bitbucket.core :as core]))


(defn changeset
  ""
  ([user repo node opts]
   (changeset (str user "/" repo) node opts))
  ([userrepo node [{:keys [auth ret-format] :or {:auth {} :format "json"}} opts]]
   (core/make-json-request
     (core/create-request :get
                          (str "/repositories/" userrepo "/changesets/" node)
                          opts
                          ret-format)
     auth)))

(defn all-changesets
  ""
  ([user repo opts]
   (all-changesets (str user "/" repo) opts))
  ([userrepo opts]
   (changeset userrepo "" opts)))

