(ns clj-bitbucket.src
  "BitBucket Source API features
  [http://confluence.atlassian.com/display/BBDEV/Source]"
  (:require [clojure.string :as cstr]
            [clj-bitbucket [core :as core]
                           [repositories :as repos]]))

(defn fetch-source
  "Fetch the source or a file, either raw, or as json"
  ([user repo rev path opts]
   (fetch-source (cstr/join "/" user repo rev path) opts))
  ([userrepo rev path opts]
   (fetch-source (cstr/join "/" userrepo rev path) opts))
  ([userrepopath rev opts]
   ;; Split apart the userrepopath, insert after the repo the rev info, and rejoin the string
   (fetch-source (cstr/join "/" (assoc (cstr/split userrepopath #"/" 2 (str "src/" rev)))) opts))
  ([userreporevpath]
   (fetch-source userreporevpath {}))
  ([userreporevpath opts]
   ;; We can get the raw file results if :raw is in opts
   (if (opts :raw)
     (repos/fetch-repo (.replaceFirst userreporevpath "/src/" "/raw/") opts)
     (repos/fetch-repo userreporevpath opts))))

