/* Following the specification in the README.md file, provide your
 * Problem3.java class.
 */


import java.util.Arrays;

public class Problem3 {

    public static void main(String[] args) {
        Integer[] p = new Integer[5];

        p[0] = 1;
        p[1] = 10;
        p[2] = 100;
        p[3] = 1000;
        p[4] = 10000;
        

        for (int k = 0; k < p.length; k++) {
            int n = p[k];
            long startTime = System.nanoTime();

            int sum = 0;
            for (int i = 0; i < 23; i++)
                for (int j = 0; j < n; j++)
                    sum = sum + 1;

            long endTime = System.nanoTime();
            System.out.println("(a) Running Time for n: " + n + " Runtime:" + 
                    (endTime - startTime));

        }

        for (int k = 0; k < p.length; k++) {
            int n = p[k];
            long startTime = System.nanoTime();

            int sum = 0;
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++)
                    sum = sum + 1;

            long endTime = System.nanoTime();
            System.out.println("(b) Running Time for n: " + n + " Runtime:" + 
                    (endTime - startTime));

        }

        for (int k = 0; k < p.length; k++) {
            int n = p[k];
            long startTime = System.nanoTime();

            foo(n, 2);

            long endTime = System.nanoTime();
            System.out.println("(c) Running Time for n: " + n + " Runtime:" + 
                    (endTime - startTime));
        }
    }
    
    public static int foo(int n, int k) {
    if(n<=k)
        return 1;
    else
        return foo(n/k,k) + 1;
}

}
