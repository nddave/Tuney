;; This is my canvas. This is my art.

;; Assignment information
;; ---
;; Class : Artificial Intelligence
;; Assignment : Make an artificially intelligent search algorithm
;; Student : Nirman Dave

;; Program information
;; ---
;; Name : Tuney 
;; File : Player
;; File Purpose : The player file runs all the music that is played, using the Overtone library.
;; Version : 1.0
;; Description : An artificially intelligent search algorithm that searches for music tones based on the
;;					frequencies listed in its database. It evolves with every search to identify the kind
;;					of music you like and play it when you ask for it. It also classifies every frequency
;;					into the genre of the music.
;; Language : Clojure

;; Defining the namespace - Player
(ns tuney.player)
;;; This file is independent from other files and does not use
;; functions and definitions mentioned in other files.
;; However, it does import the overtone.core file, that is the
;; local server for creating frequency sounds using overtone.
(use 'overtone.core)
;; The local server is now booted up at each startup.
(boot-server)

;; =====
;; Global Definitions
;; =====

;; This area is a place to define the global variables that run through the whole program.
;; Definst definitions also take in parameters.

;; Bar plays single frequency as it is.
;; The tone output is generated using the "saw" function
;; mentioned in the Overtone library.
(definst bar [freq 220] (saw freq))

;; Baz plays single frequency as it is on the Sin wave.
(definst baz [freq 440] (* 0.3 (saw freq)))

;; Trem plays a frequency as it is on the Sin wave, along with
;; defining the depth, the rate of change and the length of play.
(definst trem [freq 440 depth 10 rate 6 length 10]
    (* 0.3
       (line:kr 0 1 length FREE)
       (saw (+ freq (* depth (sin-osc:kr rate))))))

;; Freqy plays a frequency with attack, sustain and release levels defined to
;; suit the Sin wave.
(definst freqy [freq 440 attack 0.01 sustain 0.4 release 0.1 vol 0.4] 
	(* (env-gen (lin-env attack sustain release) 1 1 0 1 FREE)
	(saw freq)
	vol))

;; Sleep time is the interval it takes between playing two frequencies.
;; This is defined in miliseconds.
(def sleep-time 
	200)

;; =====
;; Global List Definitions
;; =====

;; This area is a place to define the global lists that are used through the whole program.

;; freqy-chart-list is a database of different tones.
(def freqy-chart-list 
	(partition 5 
		;; Slurps the data from the source.
		(read-string (str "(" (slurp "src/tuney/freqy_chart.txt") ")")))
	)

;; freqy-liked-list is a database of different tones liked by the user.
(def freqy-liked-list
	(partition 5
		(read-string (str "(" (slurp "src/tuney/freqy_liked.txt") ")")))
	)

;; spit-print adds the music "liked" by the user to the databse.
(defn spit-print[word]
	;; Spits the data to the source.
	(spit "src/tuney/freqy_liked.txt" 
		(subs (str (apply list (nth freqy-chart-list word))) 1 (- (count (str (apply list (nth freqy-chart-list word)))) 1)) 
		:append true)
	(spit "src/tuney/freqy_liked.txt" "\n" :append true)
	)
