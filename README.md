# Vocabulary training program

## 1. User view

### ***1.1 Description***

It is known that knowing words in any foreign language plays a key role in mastering it. Your
communication level and knowledge assessment always depend on your vocabulary. This program is
designed to be a simple, daily training for learning new words. I recommend adding 10 new words here
every day and you won't even notice how significantly your level of German knowledge will increase.

The program has a basic set of 100 words of B1 level, but it is also possible to delete words and
add new ones. You can also use the program as a dictionary or view the entire list of entered words.

The most important thing is the ability to train your word knowledge. You will be given a random
word from the list of not yet learned or partially learned words. Your task is to correctly write
the translation of this word in the console. If you answer correctly 3 times, the word will be
learned and will no longer appear in your training.

Of course, you have the ability to view the results of your efforts. The program will show you the
number of learned words (more than 2 correct answers) and the number of words in the learning
process (1 or 2 correct answers), as well as visually display the percentage of learned/in
progress/yet to be learned words.

And, of course, your results will not disappear after closing the program, everything is saved.

### ***1.2 Program Interface***

1:VOCABULARY

* View the English-German dictionary;
* Add new word to Dictionary
* Delete word from Dictionary
* Translation of an English-German word
* Back to Menu

2:TRAINING

* Word: Super
* Enter your translation:

3:REPORT

Number of learned word: 1 / 7 |
Number of word in progress: 3 / 7

🟩🟩🟩🟩🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛

4:EXIT
## 2. Point of entry
To start the program, after downloading the data from repository, run the file "src/Runner".

## 3. Program architecture

### ***3.1 UML diagram***

![program architecture, interaction between classes](https://github.com/NesterovAlexsey/Project3JavaBasicCourse/blob/main/ProjectStruction.png)

### ***3.2 Shot class description***
The program uses 7 classes, briefly described below. In total, the program has 37 methods. 
The following technical solutions have been applied: working with files (upload-download), 
Enam, compareTo, binary search, sorting, working with the Stream class, etc.
* __Runner__ - launches the program, reads data from the file, 
creates and fills an element of the Dictionary class with a list of elements of the Word class;
* __MyDictionary__ - stores a list of words in the constructor, can overwrite it, 
return it on request and print;
* __Word__ - It has several types of constructors, 
stores the word and its translation and the number of its mentions, can compare words, print, 
return on request;
* __Fasade__ - implements the facade structural pattern, the client is the Runner class;
* __Vocabulary__ -the class launches a menu sub-item - a dictionary. It can read data from the user,
find the right word on request, or find the right place to add a new word. deletes, 
adds words to the dictionary and finds the translation of words;
* __TrainWordTranslate__ - asked a word by a randomly selected number, analyzes the result, 
counts mentions of words and limits the output of words that are considered "learned" by users by 
the number of correct repetitions;
* __Report__ - counts the number of learned words or words in the learning process, relative to 
the total volume of the dictionary. Displays data on the screen;