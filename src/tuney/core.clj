;; This is my canvas. This is my art.

;; Assignment information
;; ---
;; Class : Artificial Intelligence
;; Assignment : Make an artificially intelligent search algorithm
;; Student : Nirman Dave

;; Program information
;; ---
;; Name : Tuney 
;; File : Core
;; File Purpose : The core file has the core functions for the program.
;; Version : 1.0
;; Description : An artificially intelligent search algorithm that searches for music tones based on the
;;					frequencies listed in its database. It evolves with every search to identify the kind
;;					of music you like and play it when you ask for it. It also classifies every frequency
;;					into the genre of the music.
;; Language : Clojure

;; Defining the namespace - Core
;; Using functions and definitions mentioned in the Player file and the Functions file.
(ns tuney.core
	[:use tuney.player]
	[:use tuney.functions])

;; The main function runs when the program boots up.
;; It runs a series of frequencies through the "sing" function.
(defn -main[]
	(sing 213 312 240 220 440))

;; This is a fun function that acts as a welcome "song" for this program.
;; You can run it to listen to a quick music piece made up of the chords:
;; C4 - E4 - G4.
(defn welcome-song[]
	(sing 261.6 261.6 261.6)
	(Thread/sleep sleep-time)
	(sing 329.6 329.6 329.6)
	(Thread/sleep sleep-time)
	(sing 392 392 392))

;; This is a function that allows you to check if the program runs correctly and as defined.
;; It runs some of they key functions in the proogram. If all of them are executed, it returns
;; a string that says "perfect".
(defn check[]
	(-main)
	(welcome-song)
	(sing 213 312 220 440 523)
	(sing 213 312 220 440)
	(sing 213 312 220)
	(sing 213 312)
	(sing 213)
	(search "check")
	(println "check result : perfect"))