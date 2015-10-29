Geslite
=======

![alt tag](http://3.bp.blogspot.com/-uBXN0GwDsYQ/VjFpgOjhzCI/AAAAAAAACQs/8-7oJcSE3Rw/s1600/Tuney.png)

An artificially intelligent music search algorithm that searches for music tones based on the frequencies listed in its database. It evolves with every search to identify the kind of music you like and play it when you ask for it. It also classifies every frequency into the genre of the music.

Getting Started
=======
The Tuney library is quick and easy to setup. Assuming you have the following downloaded, installed and running.
* Clojure
* Leiningen
After this, download the Tuney.zip file, and run it with REPL.

The first function you will see will be Search function. When you carry out a search function, you define the music genre in the parameters.

> tuney.core=> (search "rock")

Then it will play a music and ask you if you liked it. If you reply with Yes, the program saves your music into the "favourites" databsed. Else it plays a new music for you.
 
> Did you like it? [y/n] : 

You can also search through frequency.

> tuney.core=> (search 220 532)

Where "220" is the minimum frequency and "532" is the maximum frequency.

You can also call to listen to your favourite songs.

> tuney.core=> (fav-play)

There are way more possibilities that are possible with this library.

You can explore the source code to know more.

Assignment information
=======
This program is written as a part of the Artificial Intelligence Assignment.

- Program Name : Tuney
- Program Description : An artificially intelligent music search algorithm that searches for music tones based on the frequencies listed in its database.
- Subject : Artificial Intelligence
- Assignment : Write an artificially intelligent search algorithm.
- Language : Clojure
