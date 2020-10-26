# Student README file

Problem 1:
Step 1: Open the terminal and type "javac Rectangle.java" to compile the Rectangle class.
Step 2: Open the terminal and type "javac Problem1.java" to compile the program.
Step 2: Then write java Problem1 to run the program.

Problem 2:
Step 1: Open the terminal and type javac Rectangle.java to compile the Rectangle class.
Step 2: Open the terminal and type javac Problem2.java to compile the program.
Step 2: Then write java Problem2 to run the program.

Problem 3:
Step 1: Open the terminal and type javac Problem3.java to compile the program.
Step 2: Then write java Problem3 to run the program.


## Problem 1

Define a rectangle class that provides a *getLength* method and and a
*getWidth* method.  Rectangle should also implement the *Comparable*
interface; it should compare by **perimeter**. Create another class
called Problem1 that has the findMax routine (included below) and add
a main method that creates an array of Rectangle objects and finds the
largest Rectangle on the basis of its perimeter.

## Problem 2

In the file Problem2.java implement a static method with the signature:
```
public static <AnyType extends Comparable<AnyType>>       
     int binarySearch(AnyType[] a, AnyType x);
```
This method should then trigger another helper method that searches the array recursively for the value x.

Finally, create a main method that builds an array of rectangles (use your class from problem 1) and then sort that array with Arrays.sort.  
Demonstrate your recursive binarySearch method on this array.

## Problem 3

In Problem3.java, implement the three code fragments from written problem 3.  Have your code repeatedly run each fragment on various values of n. Time each run and see if the progression of timings as n increases matches the predicted run times from your written assignment.  

By default the java virtual machine uses a feature called the Just-In-Time (JIT) compiler that actually compiles the java bytecode down to native machine code for the computer on which you're running.  The use of the JIT generally speeds up execution of code, but in this case will cause the run times to not follow the pattern you would expect since it does some on-the-spot optimizations. Therefore, you must disable the JIT to do this problem. If you are running java from the command line, you can disable the JIT for a single run by using the command line argument: -Xint. So if you want to run your class Problem 3 with the JIT turned off:

java -Xint Problem3

Place the results of your timing and your explanation in a file called Problem3.txt.  For the third fragment, set k equal to 2 for all of your testing.  The easiest way to time your run is to execute the following code before each fragment:

long startTime = System.nanoTime();
then after each fragment place:

long endTime = System.nanoTime();

The elapsed time is the difference between these two variables.
