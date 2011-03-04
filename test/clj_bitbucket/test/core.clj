(ns clj-bitbucket.test.core
  (:require [clj-bitbucket.core :as cbbc] :reload)
  (:use [lazytest.deftest :only (deftest is are)]
        [lazytest.describe :only  (describe testing given it)]))

(describe "Creating urls"
  (testing "when no version is passed in")
  (testing "when the version is specified")
  (testing "when the URL is malformed")
  (testing "When nil is passed in for the url"))

(describe "Creating request maps"
  (testing "when the method is passed in as a string")
  (testing "when the method is passed in as a keyword")
  (testing "when the api-version is in the opts map")
  (testing "when a new return format is passed in")
  (testing "when a format is passed, but one already exists on the query string"))

(describe "Creating auth credentials"
  (it "should return the credentials in a vector"
    (= (cbbc/make-auth "user" "pass") ["user" "pass"])))

