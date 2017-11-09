import java.util.*;

/**
 * Created by ramiz on 11/9/17.
 */
public class Challenges {
    public static void main(String args[]) {
//        testRansomNoteChallenge();
//        testStringAnagrams();
//        testArrayLeftRotation();
    }

    /* ****************************************************************
     *  Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
     *
     *   A Node is defined as:
     *       class Node {
     *           int data;
     *          Node next;
     *      }
    ********************************************************************/

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        map.put(head, 1);

        while (head.next != null) {
            head = head.next;
            if (map.containsKey(head)) {
                return true;
            }

            map.put(head, 1);
        }

        return false;
    }


    /**************************
     * Ransom Note Challenge solution: Identify if note string can be made of
     * words from magazine string
     */

    public static void testRansomNoteChallenge() {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

        //should print true
        System.out.println(solveRansomNote(magazine, note));
    }

    public static boolean solveRansomNote(String magazine, String note) {
        HashMap<String, Integer> magazineMap = new HashMap<>();
        HashMap<String, Integer> noteMap = new HashMap<>();

        String magazineWords[] = magazine.split(" ");
        String[] noteWords = note.split(" ");

        initializeMap(magazineMap, magazineWords);
        initializeMap(noteMap, noteWords);

        Set set = noteMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();

            if (!magazineMap.containsKey(key) || magazineMap.get(key) < value) {
                return false;
            }
        }

        return true;
    }

    public static void initializeMap(Map<String, Integer> map, String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int prevCount = 0;
            if (map.containsKey(word)) {
                prevCount = map.get(word);
            }
            map.put(word, ++prevCount);
        }
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
