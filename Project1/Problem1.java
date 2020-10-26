import java.util.Arrays;

public class Problem1 {

    public static <AnyType extends Comparable<AnyType>> AnyType findMax
            (AnyType[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];

    }

    public static void main(String[] args) {

        //Creates Array of rectangles rList  
        Rectangle[] rList = new Rectangle[3];
        
        //Hardcoded rectangles
        Rectangle r1 = new Rectangle(5, 5);
        Rectangle r2 = new Rectangle(10, 5);
        Rectangle r3 = new Rectangle(8, 2);

        //Adds rectangles to rList
        rList[0] = r1;
        rList[1] = r2;
        rList[2] = r3;
        
        //Runs findMax method and prints result
        System.out.println(findMax(rList));
        
    }
}


