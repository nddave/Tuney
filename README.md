Tuney
=======

![alt tag](http://3.bp.blogspot.com/-uBXN0GwDsYQ/VjFpgOjhzCI/AAAAAAAACQs/8-7oJcSE3Rw/s1600/Tuney.png)

An artificially intelligent music search algorithm that searches for music tones based on the frequencies listed in its database. It evolves with every search to identify the kind of music you like and play it when you ask for it. It also classifies every frequency into the genre of the music.

The algorithm uses depth first search. It does not search for an exact music piece but searches for a music piece in a range for frequencies, making it search more possible solutions, hence making it smarter. Also, what it does is that it learns what kind of music you liked listening to, so that the next time you search for it, it does not search through the whole database, but directly returns the music you liked.

Getting started
=======
The Tuney library is quick and easy to setup. Assuming you have the following downloaded, installed and running.

* Clojure
* Leiningen

After this, download the Tuney.zip file, and run it with REPL.

The first function you will see will be Search function. When you carry out a search function, you define the music genre in the parameters.
```clojure
tuney.core=> (search "rock")
```
Then it will play a music and ask you if you liked it. If you reply with Yes, the program saves your music into the "favourites" databsed. Else it plays a new music for you.
```clojure
Did you like it? [y/n] : 
```
You can also search through frequency.
```clojure
tuney.core=> (search 220 532)
```
Where "220" is the minimum frequency and "532" is the maximum frequency.

You can also call to listen to your favourite songs.
```clojure
tuney.core=> (fav-play)
```
There are way more possibilities that are possible with this library.

You can explore the source code to know more.

# License information ![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-lightgrey.svg)

This work is licensed under a [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/). 

Program is created by [Nirman Dave](http://www.nirmandave.com) as a form of assignment for *Artificial Intelligence CS263* course at *Hampshire College, Amherst MA* under *Professor Lee Spector*.
