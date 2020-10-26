/* Following the specification in the README.md file, provide your
 * SymbolBalance class.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class SymbolBalance {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        File inFile = new File(fileName);
        Scanner input = new Scanner(inFile);
        wordList(input);
    }

    public static boolean wordList(Scanner input) {
        MyStack<Character> stack = new MyStack<Character>();
        ArrayList<Character> open = new ArrayList<Character>();
        open.add('[');
        open.add('{');
        open.add('(');
        ArrayList<Character> end = new ArrayList<Character>();
        end.add(']');
        end.add('}');
        end.add(')');
        int lineNum = 0;
        boolean error = false;

        // Check for Symbol Balance
        while (input.hasNext() && error == false) {
            lineNum++;
            String line = input.nextLine();
            char[] letters = line.toCharArray();
           
            for (int i = 0; i < letters.length; i++) {
                char letter = letters[i];
                char prev_letter = ' ';
                char next_letter = ' ';

                if (i > 0) {
                    prev_letter = letters[i - 1];
                }
                if (i < letters.length - 1) {
                    next_letter = letters[i + 1];
                }

                char peek = ' ';
                if (stack.isEmpty() == false) {
                    peek = (Character) stack.peek();
                }

                if (peek == '"') { // we're in the quote
                    if (letter == '"') { // closing
                        stack.pop();
                    }
                } else if (peek == '*') { // we're in the comment
                    if (letter == '*' && next_letter == '/') { // closing
                        stack.pop();
                    }
                } else {
                    if (open.contains(letter)) {
                        stack.push(letter);
                    } else if (end.contains(letter)) {
                        if (stack.isEmpty() == true) { // empty stack
                            error2(lineNum);
                            error = true;
                        } else {
                            char popped = stack.pop();
                            if (letter == ')' && popped != '(') { // () symbol
                                error1(lineNum, letter, popped);
                                error = true;
                            } else if (letter == ']' && popped != '[') { // [] symbol
                                error1(lineNum, letter, popped);
                                error = true;
                            } else if (letter == '}' && popped != '{') { // {} symbol
                                error1(lineNum, letter, popped);
                                error = true;
                            }
                        }
                    } else if (letter == '"') {
                        stack.push(letter);
                    } else if (letter == '*' && prev_letter == '/') {
                        stack.push(letter);
                    }
                }
            }
        }
        if ( error == false && stack.isEmpty() == false) { // non-empty stack
            char peek = (Character) stack.peek();
            error3(peek, stack.size());
            error = true;
        }
        if (error == true) {
            return false;
        } else {
            correct(); // correct
            return true;
        }
    }

    //Error and Correct Codes
    public static void error1(int line, char current, char pop) {
        System.out.println(line + ": " + current + ", " + pop);
    }

    public static void error2(int line) {
        System.out.println(line + ": Empty");
    }

    public static void error3(char peek, int size) {
        System.out.println("Non-empty Stack: " + peek + ", " + size);
    }

    public static void correct() {
        System.out.println("Correct");
    }  
    
}