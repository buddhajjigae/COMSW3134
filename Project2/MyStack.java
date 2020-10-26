/* Following the specification in the README.md file, provide your 
 * MyStack class.
 */

import java.util.LinkedList;

public class MyStack<AnyType> {
      
      private LinkedList<AnyType> stack;
    
      public MyStack() {
          stack = new LinkedList();
      }
    
      public void push(AnyType x) {
          stack.addLast(x);
      }
                      
      public AnyType pop() {
          return stack.removeLast();
      }
    
      public AnyType peek() {
         return stack.getLast();
      }
          
      public boolean isEmpty() {
         if (stack.size() == 0) {
             return true;
         } else {
             return false;
         }
      }
    
      public int size() {
         return stack.size();
      }   
    
}   