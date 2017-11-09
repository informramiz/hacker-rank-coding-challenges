import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramiz on 11/9/17.
 */
public class Challenges {
    public static void main(String args[]) {
        testArrayLeftRotation();
    }

    /******************************************
     * Shift rotate array left `k` times
     */
    private static void testArrayLeftRotation() {
        int a[] = {1, 2, 3, 4, 5};
        int k = 4;
        int n = 5;

        int[] output = new int[n];
        output = arrayLeftRotation1(a, n, 9);

        //shout print = 5 1 2 3 4
        for (int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }

    public static int[] arrayLeftRotation1(int[] a, int n, int k) {
        int output[] = new int[n];
        int currentIndex = k % n;

        for (int i = 0; i < a.length; ++i) {
            output[i] = a[currentIndex];
            currentIndex = (currentIndex + 1) % n;
        }

        return output;
    }
}
