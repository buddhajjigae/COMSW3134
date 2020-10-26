## Problem 1 - Implementing a Spell Checker

Implement a spelling checker by using a hash table. You will create a class called SpellChecker in the file SpellChecker.java.  The object will try to check for spelling errors in an input file by attempting to find each word in the file in a provided dictionary. The SpellChecker object will take one input to its constructor.

* Dictionary Filename - This is a String which contains the name of dictionary file (there is a sample dictionary file in the workspace called words.txt)

The constructor of the object is tasked with parsing through the dictionary file and storing each word from the file in a Hash Set instance. The SpellChecker object will use this dictionary file as a reference when checking for spelling errors in a specified input file. You will now implement two functions to complete the functionailty of your novel SpellChecker object.

* ```public List<String> getIncorrectWords(String filename)``` - This method should return a list of all words in the input file that are incorrectly spelt according to the dictionary file provided to the constructor. The String ```filename``` contains the name of the file to be spell-checked.

When finding incorreclty spelt words, you may need to process the strings from the input file before comparing it to a word in the previously created HashSet instance. Your program should be case insensitive (so you must toLowerCase() everything). You must also strip only one leading and only one trailing punctuation. In order to ensure consistency between each student submission, the solution code and the automated grading script, we will define punctuation as anything that is not alphanumeric. Therefore, when you are stripping only one leading and one trailing punctuation, you will only check whether the first and last characters of the string are alphanumeric (number or alphabet).

* ```public List<String> getSuggestions(String word)``` - This method should return a list of all potential suggestions for the incorrectly spelt word that is provided as input.

In order to generate a suggestion for a given word, you will try all of the following techniques:

* Add One Character - Try adding a character at every point in the string and see if that creates a valid word.
* Remove One Character - Try removing one character from any position and see if that creates a valid word.
* Exchange Adjacent Characters - Try swapping two consecutive characters at any position in the string and see if that creates a valid word.

Your function should return all possible suggestions from each one of the techniques above. The order of the suggestions in the returned List object is not important.

You will also write a main method in the Problem1.java file to test the functionality of your SpellChecker object. Your main method should create a SpellChecker object with the words.txt dictionary file and should spell check any file of your choice. You can even create your own .txt file! Print out each incorrectly spelt word in the test file and also print out each word suggestion for every incorrectly spelt word.

We have provided you a sample test file to spell check. This file is called test.txt. The correct output of the SpellCheckerTester.java file for the given test.txt file has also been provided to you; the file is called output.txt. Ensuring that your output matches the one we provided does not guarantee full credit. However, it is a does indicate that your project meets at least some of the requirements.

## Problem 2 - k-Largest Values

Finding the k-largest values in a set of data - Assume you are given a sequence of values. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
```KBestCounter<T extends Comparable<? super T>> implements KBest<T>``` that keeps track of the k-largest elements seen so far in a set of data. The class should have two methods:

* ```public void count(T x)``` - process the next element in the set of data. This operation should run in the at worst O(log k) time.

* ```public List<T> kbest()``` - return a sorted (largest to smallest) list of the klargest elements. This should run in O(k log k) time. The method should restore the priority queue to its original state after retrieving the k largest elements. If you run this method twice in a row, it should return the same values.

Be aware that your KBestCounter.java class must implement the provided interface KBest.java. This is to ensure that your method declarations are correct at the time of submission. Under no circumstance should you edit the KBest.java file.

Use a Priority Queue to implement this functionality. We suggest using the built-in java.util.PriorityQueue, which implements a min-heap for you. You should NEVER have more than k elements inserted into the Priority Queue at any given time.

An example illustrates how KBestCounter could be used in this attached tester class: TestKBest.java.  We also include a skeleton for the KBestCounter class in the following file: KBestCounter.java.
