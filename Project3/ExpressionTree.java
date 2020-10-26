/* Following the specification in the README.md file, provide your
 * ExpressionTree class.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionTree {

    private Node<String> root;
    ArrayList<String> operand = new ArrayList<String>();


    /* Your constructor should take in a string containing the postfix 
    expression that you
     * are using to build your expression tree. */
    public ExpressionTree(String expression) {
        MyStack<Node> stack = new MyStack<Node>();
        operand.add("-");
        operand.add("+");
        operand.add("*");
        operand.add("/");

        String[] tokens = expression.split(" ");


        for (String i : tokens) {
            if (!operand.contains(i)) {
                Node temp = new Node(i);
                stack.push(temp);
            } else {
                Node temp = new Node(i);
                temp.right = stack.pop();
                temp.left = stack.pop();
                stack.push(temp);
            }
        }
        root = stack.pop();
        /* Put your code to build the tree here. */

    }


    /* This is the PUBLIC interface to the class. */
    public int eval() {
        return evalHelper(root);
        /* Fill in code here. */
    }

    public String postfix() {

        return "filler";

    }


    public String prefix() {
        return "filler";
        /* Fill in code here. */

    }

    public String infix() {
        return "filler";
        /* Fill in code here. */

    }

    public int evalHelper(Node root) {
        if (!operand.contains(root.element)) {
            int x = Integer.parseInt((String) root.element);
            return x;
        }

        return evalHelper(evalHelper(root.left), (String) root.element, 
                evalHelper(root.right));
    }

    public int evalHelper(int left, String expr, int right) {
        if (expr == "+") {
            return left + right;
        } else if (expr == "-") {
            return left - right;
        } else if (expr == "*") {
            return left * right;
        } else {
            return left / right;
        }
    }


    private static class Node<AnyType> {
        // Constructors
        Node(AnyType theElement) {
            this(theElement, null, null);
        }

        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;            // The data in the node
        Node<AnyType> left;   // Left child
        Node<AnyType> right;  // Right child
    }



    /* You will need to provide the private, recursive versions of these 
    methods,
     * the instance variable(s), and any static nested class that you might 
     * need below */

}