## Problem 1 - Symbol Balance

Define a class called *SymbolBalance* in the provided empty SymbolBalance.java file.

Your SymbolBalance class should take a single command line argument. This argument should be the name of another java file.

Read in the file character by character and check to make sure that all  { }'s, ( )'s, [ ]'s, " "'s, and /\* \*/'s are properly balanced. Make sure to ignore characters within literal strings and comment blocks. During iteration of the file, the symbol you are at in the loop will be referred to as ```<Current Symbol>``` henceforth.

You **do not need** to handle single line comments (those that start with //), literal characters (things in single quotes), or the diamond operator(<>).

There are a number of error cases:

* The file ends with one or more opening symbols missing their corresponding closing symbols.
* There is a closing symbol without an opening symbol.
* There is a mismatch between closing and opening symbols (for example: { [ } ] ).

Your program should output whether or not the symbols are all appropriately balanced.  If they are not, indicate which error condition occurred and what symbol type caused the problem. 

The output should follow the following format. Please make sure you stick to the below format to ensure that the automated script used to correct the homework assigns the correct score based on your output.

* If there is a mismatch after popping the stack: ``` <Line Number>: <Current Symbol>, <Symbol Popped>```
* If you are popping an empty stack: ```<Line Number>: Empty```
* If the stack is not empty after reading through the entire file: ```Non-Empty Stack: <Top Element>, <Size of Stack>```
* If the file is syntactically correct: ```Correct```

In the case for multi-line comments, only push and pop the * character. Do **not** attempt to push the / character or the string /*.

You will need to write your own stack class for this. It should be generic (in this particular case you will be pushing Character objects on it, but it should be capable of handling any object reference).  Call your stack class: *MyStack.java*. You should use *java.util.LinkedList* as an instance variable in your *MyStack* class, but in the implementation of your stack methods, you are only allowed to use its basic  list operations, not the stack operations themselves (that is, do not use LinkedList's native push and pop methods).  Your stack should implement the following methods:

* ```public void push(AnyType x)```
* ```public AnyType pop()```
* ```public AnyType peek()```
* ```public boolean isEmpty()```
* ```public int size()```

Define this class in the provided empty MyStack.java file.

Here is an example.  You are given a file with the following contents:

```public class Test{
    public static final void main(String[ ) args) { 
        System.out.println("Hello."); 
    } 
}
```

You would run your program like this:

```java SymbolBalance Test.java```

and the output should be something like:

```Unbalanced! Symbol ) is mismatched.```

We have provided you with a number of Test inputs in the sub-folder TestFiles. We will use our own test files to grade your performance on all conditions - those files will be released **after** the assignment is due.


## Problem 2 - Two Stack Queue

Build a queue out of two completely separate stacks, S1 and S2. Enqueue operations happen by pushing the data on to stack 1.
Dequeue operations are completed with a pop from stack 2.  

Obviously you will have to find some way to get the input stack information over to the output stack.  Your job is to figure out how and when to do that, using only push and pop operations.

* Write a class TwoStackQueue that provides the Queue ADT (as specified in *MyQueue* interface provided in the file MyQueue.java) using two stacks. Your class should explicitly implement the interface provided above.  Since the interface is generic, your class should be as well. Provide all methods specified in the interface. Your class should not use any additional memory to store the data in the queue except for the two stacks. 
For your stacks, use the MyStack class that you implemented in the first problem.

* Write a tester class with a main method to demonstrate that your TwoStackQueue works correctly (by enqueueing a number of objects and then dequeueing and printing them in the correct order).   Call your tester class Problem2.java.  You can find a sample tester class in the file TwoStackQueueTester. It is similar to the one that we will use to grade your submission.
Your tester should try different examples than the ones from this sample.

* In a file called Problem2.txt, discuss the big-O running time of the enqueue and dequeue operation for your queue implementation. (Hint: one of these operations should always be O(1) the other can vary a bit, but shouldn't always be O(N)).
