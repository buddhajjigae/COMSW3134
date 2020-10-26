import java.util.Arrays;

public class Problem2 {

    public static void main(String[] args) {

        //Hardcoded Rectangles
        Rectangle r1 = new Rectangle(6, 8);
        Rectangle r2 = new Rectangle(2, 4);
        Rectangle r3 = new Rectangle(6, 7);
        Rectangle r4 = new Rectangle(3, 1);
        Rectangle r5 = new Rectangle(5, 9);

        //Creates Rectangle Array rList
        Rectangle[] rList = new Rectangle[5];

        //Adds rectangles to rList
        rList[0] = r5;
        rList[1] = r3;
        rList[2] = r2;
        rList[3] = r1;
        rList[4] = r4;

        //Rectangle r to be searched
        Rectangle r = new Rectangle(6, 7);

        //Sorts rList
        Arrays.sort(rList);

        //Runs binarySearch method to find Rectangle r
        int index = binarySearch(rList, r);
        System.out.println(index);
        if (index < 0) {
            System.out.println("Value not in array");
        } else {
            System.out.println("Located at index position: " + index);
        }
    }

    
    public static <AnyType extends Comparable<AnyType>>
    int binarySearch(AnyType[] a, AnyType x) {
        return binarySearch(a, x, 0, a.length - 1);
    }
 
    
    //Helper method for recursive Binary Search
    public static <AnyType extends Comparable<AnyType>>
    int binarySearch(AnyType[] a, AnyType x, int start, int end) {
        
        //Finds mid point of array to be searched
        int index = (end + start) / 2;
        int lo = start;
        int hi = end;
        
        //Base Case
        if (hi < lo) {
            return -1;
        }

        //Obtains value of element at current index
        AnyType indexRect = a[index];

        //Compares rectangle perimeter's using compareTo
        if (x.compareTo(indexRect) == 0) {
            return index;
        } else if (x.compareTo(indexRect) > 0) {
            lo = index + 1;
        } else if (x.compareTo(indexRect) < 0) {
            hi = index - 1;
        }
        return binarySearch(a, x, lo, hi);

    }
}
