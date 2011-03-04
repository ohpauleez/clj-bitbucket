(ns clj-bitbucket.core
  "The core functions for making requests to the BitBucket API;
  These are really only used by the other API files "
  (:require [clj-http.client :as client]
            [clj-json :as json]))


(defn create-url
  ""
  ([url]
   (create-url url "1.0"))
  ([url version]
   (str "https://api.bitbucket.org/" version "/" url)))

(defn create-request
  ""
  ([method url opts]
   (merge {:method (keyword method) :url (create-url url (get opts :api-version "1.0"))}
          (dissoc opts :api-version :auth :format)))
  ([method url opts ret-format]
   (create-request method url (assoc-in opts [:query-params :format] ret-format))))

(defn make-request
  ""
  ([req]
   (make-request {} req))
  ([req auth]
   (-> (client/request (merge {:basic-auth auth} req) :body json/read-string))))

;; This might be useful to third parties, so they don't need to look at the clj-http docs
(defn make-auth
  [user pass]
  (vector user pass))

