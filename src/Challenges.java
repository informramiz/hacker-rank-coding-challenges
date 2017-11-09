import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramiz on 11/9/17.
 */
public class Challenges {
    public static void main(String args[]) {
        testStringAnagrams();
//        testArrayLeftRotation();
    }

    /* * *************************************
     * Identify characters needed to be deleted to make two string Anagrams
     */
    public static void testStringAnagrams() {
        String first = "cde";
        String second = "abc";
        //shout be 4
        int number = numberNeededForMakingStringAnagram(first, second);
        System.out.println(number);
    }

    public static int numberNeededForMakingStringAnagram(String first, String second) {
        int firstCount[] = new int[26];
        int secondCount[] = new int[26];

        for (int i = 0; i < first.length(); ++i) {
            int index = first.charAt(i) - 'a';
            firstCount[index]++;
        }

        for (int i = 0; i < second.length(); ++i) {
            int index = second.charAt(i) - 'a';
            secondCount[index]++;
        }

        int diff = 0;
        for (int i = 0; i < 26; ++i) {
            diff += Math.abs(firstCount[i] - secondCount[i]);
        }

        return diff;
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
