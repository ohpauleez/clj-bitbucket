(ns 
  ^{:doc "The core functions for making requests to the BitBucket API;  
  These are really only used by the other API files."
    :author "[Paul deGrandis](https://github.com/ohpauleez)"}
  clj-bitbucket.core
  (:require [clj-http.client :as client]
            [clj-json.core :as json]))


(defn create-url
  "Create a RESTful URL for a specifc version of the BitBucket API  
  Arguments:  
    url - a string, the tail end of the RESTful URL. ex: /respositories/some_user/some_repo/  
    [version] - a string, the API version you're accessing ['1.0']. ex: 1.0  
  Returns:  
     - a string, the final BitBucket API URL that should be called"  
  ([url]
   (create-url url "1.0"))
  ([url version]
   (str "https://api.bitbucket.org/" version "/" url)))

(defn create-request
  "Create a request map for an API request, that can be serviced by the http client  
  Arguments:  
    method - a string or keyword, the HTTP method you're hitting the endpoint with. ex: :get  
    url - a string, the RESTful URL, as returned by create-url.  
    opts - a map, additional options for the BitBucket API or for the HTTP Client request  
    [ret-format] - a string, the format you want the RESTful call to return to you ['json']. ex: 'xml'  
  Returns:  
     - a map that can be passed directly to the http client to service."  
  ([method url opts]
   (merge {:method (keyword method) :url (create-url url (get opts :api-version "1.0"))}
          (dissoc opts :api-version :auth :format)))
  ([method url opts ret-format]
   (create-request method url (assoc-in opts [:query-params :format] ret-format))))

(defn make-request
  "Service a RESTful request.  See clj-http.client/request for more information.  
  Arguments:  
    req - a request map, as returned by create-request.  
    [auth] - a vector, [username password]  
  Returns:  
     - a string, the result of the servicing the call."  
  ([req]
   (make-request {} req))
  ([req auth]
   (client/request (merge {:basic-auth auth} req))))

(defn make-json-request
  "Like make-request, but will force format to be json, and json/parse-string you the result"
  ([req]
   (make-json-request {} req))
  ([req auth]
   (-> (assoc-in req [:query-params :format] "json") (make-request auth) :body json/parse-string)))

;; This might be useful to third parties, so they don't need to look at the clj-http docs
(defn make-auth
  [user pass]
  (vector user pass))

