/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */

public class Problem2 {

    public static final void main(String[] args) {

	TwoStackQueue<String> test = new TwoStackQueue<String>();
	System.out.println(test.size());

    System.out.println(test.dequeue());    
	test.enqueue("Alex");
	test.enqueue("Faisal");
    System.out.println(test.size());
    System.out.println(test.dequeue());
	test.enqueue("John");
    System.out.println(test.size());    
	System.out.println(test.dequeue());	
	test.enqueue("Nam");
	test.enqueue("Ham");
    System.out.println(test.size());
    System.out.println(test.dequeue());
    System.out.println(test.dequeue());    
	System.out.println(test.dequeue());
    System.out.println(test.size());
	test.enqueue("Chris");
    test.enqueue("Dahvid");
    System.out.println(test.dequeue());
    System.out.println(test.dequeue());       
    System.out.println(test.size());
    test.enqueue("Lawrence");
    System.out.println(test.dequeue());
    test.enqueue("Kevin");
    System.out.println(test.dequeue());
    System.out.println(test.size());

	while(!test.isEmpty())
	    System.out.println(test.dequeue());
    }
    
}