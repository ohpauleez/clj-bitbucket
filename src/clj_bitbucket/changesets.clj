(ns clj-bitbucket.changesets
  "BitBucket Changesets API features
  [http://confluence.atlassian.com/display/BBDEV/Changesets]"
  (:require [clj-bitbucket.core :as core]
            [clj-bitbucket.repositories :as repos]))


(defn changeset
  ""
  ([user repo node opts]
   (changeset (str user "/" repo) node opts))
  ([userrepo node opts]
   (repos/fetch-repo (str userrepo "/changesets/" node) opts)))

(defn all-changesets
  ""
  ([user repo opts]
   (all-changesets (str user "/" repo) opts))
  ([userrepo opts]
   (changeset userrepo "" opts)))

