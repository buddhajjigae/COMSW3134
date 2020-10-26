public class TwoStackQueueTester {



    /** If implemented correctly, this code should output: 
     *  0
     *  Peter
     *  2
     *  Paul
     *  Mary
     *  Simon
     *  Alvin
     *  Theodore
     */
    public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("Peter");
	q.enqueue("Paul");
	q.enqueue("Mary");
	System.out.println(q.dequeue());
	System.out.println(q.size());
	q.enqueue("Simon");
	q.enqueue("Alvin");
	System.out.println(q.dequeue());
	q.enqueue("Theodore");

	while(!q.isEmpty())
	    System.out.println(q.dequeue());


    }





}