;; This is my canvas. This is my art.

;; Assignment information
;; ---
;; Class : Artificial Intelligence
;; Assignment : Make an artificially intelligent search algorithm
;; Student : Nirman Dave

;; Program information
;; ---
;; Name : Tuney 
;; File : Project
;; File Purpose : The project file contains dependencies needed to run the Overtone library.
;; Version : 1.0
;; Description : An artificially intelligent search algorithm that searches for music tones based on the
;;					frequencies listed in its database. It evolves with every search to identify the kind
;;					of music you like and play it when you ask for it. It also classifies every frequency
;;					into the genre of the music.
;; Language : Clojure

(defproject tuney "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; Main file defined.
  :main tuney.core
  :dependencies [[org.clojure/clojure "1.7.0"] 
  				 [org.clojure/clojure "1.3.0"]
  				 ;; Dependency to fun the Overtone library mentioned below.
    			 [overtone "0.6.0"]])