## Problem 1 - Implementing Expression Trees

Implement a class called *ExpressionTree* in the provided ExpressionTree.java file. The constructor to ExpressionTree will take in a String that contains a postfix expression. The operands will be integers and the binary operators will be restricted to +, -, *, and /. Individual tokens, that is, the operands and operators, will be delimited by spaces. So for example:

34 2 - 5 *

would mean (34-2)*5.

Your constructor will run the stack based algorithm we discussed in class to build an expression tree. ExpressionNode will be a nested class within ExpressionTree. You may use any code posted on Canvas or from the Weiss textbook as a starting point for this assignment. For a stack data structure, you can either use java.util.LinkedList, your own class from Homework 2, or the MyStack.java file from the solutions for Homework 2 (once they are uploaded).  Please indicate your choice in the STUDENTREADME.md file.

Once you have the ExpressionTree constructed you should provide the following four methods plus a constructor:

* ```public int eval()``` - this method, when invoked on an expression tree object, will return the integer value associated with evaluating the expression tree. It will need to call a private recursive method that takes in the root.
* ```public String postfix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root.
* ```public String prefix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding prefix expression. It will need to call a private recursive method that takes in the root.
* ```public String infix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding correct infix expression. Keep in mind that parenthesrs will be needed (excessive parenthesis will be tolerated as long as they are correctly placed). It will need to call a private recursive method that takes in the root.
* ```public ExpressionTree(String expression)``` - this is the constructor of the expression tree.  It will take in a String that stores a postfix expression (as indicated above). Build the expression tree from that postfix expression using the stack based algorithm here.

We have provided a skeleton of ExpressionTree.java; fill in all the parts as needed.  DO NOT change the method headers for the public methods listed above, or the constructor.

Fill in the class Problem1.java (specifically, its main method) such that it instantiates an expression tree on a hard coded string representing a postfix expression tree, and demonstrate all of the methods listed above.

## Problem 2 - Indexing Text with an AVL Tree

Fill in the class FileAvl.java such that it indexes the words contained in a text file. The constructor of the FileAvl object should take in the file name as a parameter. It will then go through the input file line by line. For each line, it extracts each word, and inserts that word along with its line number into an AVL tree. Each element of the AVL tree should contain a unique word and a java.util.LinkedList of line numbers where that word occurs.

To implement this AVL tree, use the AvlTree code from the textbook as a starting point. I've included this code in the project workspace.  I've also included the UnderflowException class which is needed for AvlTree to compile.  

Add the following functionality to the AvlTree class by modifying the file:

* Make sure the elements in the AvlTree are pairs of a word and a linked list storing line numbers. The relative order of elements in the data structure should depend on the word only.  To do this I recommend adding a LinkedList object to the existing AVLNode class. You will also need to edit the add method ```insert``` method to take both a word and a line number.  In this particular case it's also not necessary for AVLTree to be generic, so you may remove generics and make the class simply an AvlTree of String objects.

You are allowed to remove extraneous methods from AVLTree.

Give the following functionality to your FileAvl class: 

* Write the method public void ```indexWord(String word, int line)``` that adds an occurrence of the word ```word``` in line ```line``` to the AvlTree instance of the FileAvl object. If a word already exists in the AVL Tree, simply add the new line number to the existing node. If a word appears on the same line twice, it should only have one entry in the list for that line. You may assume that ```word``` and ```line``` are valid inputs to the function.
* Write the method public List ```getLinesForWord(String word)``` that looks up a word and returns a list of lines in which it occurs for a given FileAVL object. If the word does not exist in the AvlTree, return an empty list.
* Write the method public void ```printIndex()``` the prints out each unique word that is stored in the AvlTree along with a list of line numbers in which that word appears, in alphabetical order. The output format should be as given below. Any deviation from the prescribed format may result in point deductions.

```<Word>: <Line Number 1>, <Line Number 2>, <Line Number 3>, ........```

Finally, in the file Problem2.java, write a main method to create an instance of your FileAVL class and use it to index the words contained in a text file (provided to the program as a command line argument). Ignore case in the input text (insert everything as lower case). Do NOT remove punctuation. You must split the line into words by whitespace using the `String` class' `split` method (for example, "data structures   is fun" should be four words: {"data", "structures", "is", "fun"}). When indexing has finished, the program should call the `printIndex` method to display a list of unique words in the text file and the line numbers in which that word occurs. 

I've provided a very simple file called ```test.txt``` that you can use to test your program.  I've also provided a file called ```output.txt``` which contains the correct output for the program on the ```test.txt``` file.  I've also provided a much larger test file called ```frank.txt```. For the larger test file I will not be providing sample output.  

The TAs will test your code on a variety of additional test files.
