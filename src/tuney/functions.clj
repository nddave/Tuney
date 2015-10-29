;; This is my canvas. This is my art.

;; Assignment information
;; ---
;; Class : Artificial Intelligence
;; Assignment : Make an artificially intelligent search algorithm
;; Student : Nirman Dave

;; Program information
;; ---
;; Name : Tuney 
;; File : Functions
;; File Purpose : The functions file is the engine for this search program.
;; Version : 1.0
;; Description : An artificially intelligent search algorithm that searches for music tones based on the
;;					frequencies listed in its database. It evolves with every search to identify the kind
;;					of music you like and play it when you ask for it. It also classifies every frequency
;;					into the genre of the music.
;; Language : Clojure

;; Defining the namespace - Functions
;; Using functions and definitions mentioned in the Player file.
(ns tuney.functions
	[:use tuney.player])

;; =====
;; Music Functions
;; =====

;; This area is a place to define the important functions for the "music" aspect
;; of this program.

;; Sing is a function that plays a set of frequencies.
;; It takes in 0 - 5 frequency value(s) (arguments) in its parameters,
;; and plays each frequency with an interval of 2 seconds. The time for this interval
;; is defined by the variable "sleep-time", (mentioned in the player file) which is set
;; to 2 seconds.
(defn sing
	;; When the user inputs no arguments the program returns the following.
	([] 
	(println "Please input upto five frequences so that I can sing it."))

	;; Playing one frequency (taking in one argument only)
	;; The music output is generated using the function "freqy".
	;; This has been defined in the Player file.
	([f1]
	(freqy f1))

	;; Playing two frequencies (taking in two arguments only)
	([f1 f2]
	(freqy f1)
	(Thread/sleep sleep-time)
	(freqy f2))

	;; Playing three frequencies (taking in three arguments only)
	([f1 f2 f3]
	(freqy f1)
	(Thread/sleep sleep-time)
	(freqy f2)
	(Thread/sleep sleep-time)
	(freqy f3))

	;; Playing four frequencies (taking in four arguments only)
	([f1 f2 f3 f4]
	(freqy f1)
	(Thread/sleep sleep-time)
	(freqy f2)
	(Thread/sleep sleep-time)
	(freqy f3)
	(Thread/sleep sleep-time)
	(freqy f4))

	;; Playing five frequencies (taking in five arguments only)
	([f1 f2 f3 f4 f5]
	(freqy f1)
	(Thread/sleep sleep-time)
	(freqy f2)
	(Thread/sleep sleep-time)
	(freqy f3)
	(Thread/sleep sleep-time)
	(freqy f4)
	(Thread/sleep sleep-time)
	(freqy f5))
	)

;; =====
;; Search Functions
;; =====

;; This area is a place to define the important functions for the "search" aspect
;; of this program.

;; This is the interaction function.
;; After displaying every search result this function asks the user if they like the result (music).
;; If the user replies "yes", then the search result (music) is stored in its database for later use.
;; Else, the program moves forward to find better music.
(defn like[play]
	;; "freqy-char-list" is a database of songs (mentioned in player file).
	;; With the key "play", the program accesses this database for the music.
	(apply sing (nth freqy-chart-list play))
	(def ask (do (print "Did you like this tune? [y/n] : ") (flush) (read-line)))
	(if (= ask "y")
		;; "spit-print" is a function defined in the player file which adds the "liked" music
		;; to a new database.
		(spit-print play)
		;; Recur allows the program to keep looking for new music.
		(recur (inc play))
		)
	)

;; This is the freqy-search function.
;; This searches for music based on the minimum and maximum frequencies defined by the user.
(defn freqy-search[minf maxf]
		(loop [i 0]
			(when (< i (+ (count freqy-chart-list) 1)))
			;; If minimum frequency is equal to that defined by the user and 
			;; if maximum frequency is equal to that defined by the user then run the "like" function.
			(if (and (= (apply min (nth freqy-chart-list i)) minf) (= (apply max (nth freqy-chart-list i)) maxf))
			(like i)
			;; Else keep searching for new music.
			(recur (inc i))
			)
		)
	)

;; This is the search funcion.
;; The user won't enter the frequencies everytime to search for music.
;; So this function assigns each frequencies to a music genre.
;; Thereofre the function takes in the parameter as the "type" of music.
(defn search[type]
	(cond
		;; A check condition defined to check if the search function is working correctly.
		(= type "check")
		(println "search check : perfect")

		;; If the user searches for "rock" music.
		;; Then the music is defined to be between the frequency of 220 to 660.
		(= type "rock")
		;; And the "freqy-search" function is run to search for the music defined by the user.
		(freqy-search 220 660)

		(= type "pop")
		(freqy-search 213 523)

		(= type "roll")
		(freqy-search 226.3 446.2)

		;; If nothing works out, print "Music not found."
		:else (println "Music not found.")

		)
	)

;; This is the favorite play function.
;; This looks into the music tones you "favorited" using the "like" function.
(defn fav-play[]
	;; And randomly plays a music from it.
	(apply sing (nth freqy-liked-list (rand-int (count freqy-liked-list))))
)

