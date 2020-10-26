import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {

    private PriorityQueue<T> heap;
    private int k;

    public KBestCounter(int k) {
        //Constructor
        heap = new PriorityQueue<>(k);
        //heap max size
        this.k = k;        
    }

    public void count(T x) {        
        //adds until heap is full
        if (heap.size() < k) {
            heap.add(x);
        
        //checks to see if x is larger than min
        } else if (heap.peek().compareTo(x) < 0) {
            heap.remove();
            heap.add(x);
        }
    }

    public List<T> kbest() {        
        //kList to be returned
        List<T> kList = new ArrayList<T>();
        //temp heap that copies heap
        PriorityQueue<T> temp = new PriorityQueue<>(heap);

        while (!temp.isEmpty()) {
            kList.add(temp.poll());
        }
        
        //Reverses kList to output from highest -> lowest
        Collections.reverse(kList);        
        return kList;
    }
}