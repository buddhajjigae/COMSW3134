/* Following the specification in the README.md file, provide your
 * TwoStackQueue class.
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {

    private MyStack<AnyType> stack1;
    private MyStack<AnyType> stack2;

    public TwoStackQueue() {
        stack1 = new MyStack<AnyType>();
        stack2 = new MyStack<AnyType>();
    }

    // Performs the enqueue operation
    public void enqueue(AnyType x) {
        stack1.push(x);
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue() {
        if (stack2.isEmpty() == false) {
            return stack2.pop();

        } else if (stack1.isEmpty() == false) {
            while (stack1.isEmpty() == false) {
                AnyType x = stack1.pop();
                stack2.push(x);
            }
            return stack2.pop();
        } else {
            return null;
        }

    }

    // Checks if the Queue is empty
    public boolean isEmpty() {
        if (stack1.isEmpty() == true && stack2.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }

    // Returns the number of elements currently in the queue
    public int size() {
        return stack1.size() + stack2.size();
    }
    
}