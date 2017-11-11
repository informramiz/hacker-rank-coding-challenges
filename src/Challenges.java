import java.util.*;

/**
 * Created by ramiz on 11/9/17.
 */
public class Challenges {
    public static void main(String args[]) {
        testMergeSort();
//        testQuickSort();
//        testBubbleSort();
//        testUniqueElementChallenge();
//        testRunningMedian();
//        testQueueOfStacksChallenge();
//        testBalancedBrackets();
//        testRansomNoteChallenge();
//        testStringAnagrams();
//        testArrayLeftRotation();
    }

    /**
     * Merge sort algorithm: A highly efficient algorithm
     */
    public static void testMergeSort() {
        int[] a = {2, 9, 11, 7, 10, 0, 15};
        SortingAlgorithms.mergeSort(a);
        for (int v : a) {
            System.out.print(v + " ");
        }
    }

    /*********************
     * Quick sort algorithm
     */
    public static void testQuickSort() {
        int[] a = {2, 9, 11, 7, 10, 0, 15};
        SortingAlgorithms.quickSort(a);
        for (int v : a) {
            System.out.print(v + " ");
        }
    }

    /*********************
     * optimized Bubble sort algorithm
     */
    public static void testBubbleSort() {
        int[] a = {1, 3, 1, 6};
        SortingAlgorithms.bubbleSort(a);
        for (int v : a) {
            System.out.print(v + " ");
        }
    }


    /********
     * A list of numbers has every number in pair except one number.
     * So one and only one number is unique and all other are in pairs
     * Find that number
     */
    public static void testUniqueElementChallenge() {
        int a[] = {1, 1, 2, 2, 7, 3, 3};
        int result = 0;

        for (int v : a) {
            result = result ^ v;
        }

        System.out.println(result);
    }

    /**************************
     * Find a running median from a list of unsorted numbers comming online
     */

    public static void testRunningMedian() {
        Integer []values1 = {12, 4, 5, 3, 8, 7};
        Integer []values2 = {
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10
        };

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });

        for (Integer v : values2) {
            if (minQueue.isEmpty() && maxQueue.isEmpty()) {
                maxQueue.add(v);
            } else {
                if (v < maxQueue.peek()) {
                    maxQueue.add(v);
                } else {
                    minQueue.add(v);
                }

                balanceHeaps(minQueue, maxQueue);
            }

            double median;
            if (maxQueue.size() == minQueue.size()) {
                median = (minQueue.peek() + maxQueue.peek()) / 2.0;
            } else if (minQueue.size() > maxQueue.size()){
                median = minQueue.peek();
            } else {
                median = maxQueue.peek();
            }

            System.out.println(String.format("Median: %.1f", median));
        }
    }

    public static void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public static double getMedian1(PriorityQueue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        int size = queue.size();
        boolean isEven = queue.size() % 2 == 0;
        int medianIndex = size / 2;
        medianIndex = isEven ? (medianIndex - 1) : medianIndex;
        //extract elements before median
        for (int i = 0; i < medianIndex; i++) {
            stack.push(queue.poll());
        }

        double median;
        if (isEven) {
            int m1 = queue.peek();
            stack.push(queue.poll());
            int m2 = queue.peek();

            median = (m1 + m2) / 2.0;
        } else {
            median = queue.peek();
        }

        queue.addAll(stack);
        return median;
    }

    public static double getMedian(PriorityQueue<Integer> queue) {
        PriorityQueue<Integer> newQueue = new PriorityQueue<>();

        int size = queue.size();
        boolean isEven = queue.size() % 2 == 0;
        int medianIndex = size / 2;
        medianIndex = isEven ? (medianIndex - 1) : medianIndex;
        //extract elements before median
        for (int i = 0; i < medianIndex; i++) {
            newQueue.add(queue.poll());
        }

        double median;
        if (isEven) {
            int m1 = queue.peek();
            newQueue.add(queue.poll());
            int m2 = queue.peek();
            newQueue.add(queue.poll());

            median = (m1 + m2) / 2.0;
        } else {
            median = queue.peek();
        }

        while (!queue.isEmpty()) {
            newQueue.add(queue.poll());
        }

        queue.addAll(newQueue);

        return median;
    }

    public static Integer getElement(Integer[] array, int n) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            index = index * 2 + 1;
        }

        return array[index];
    }


    /***********************************************
     *
     * Queue of 2 Stacks: Implement a queue with 2 stacks
     */

    public static void testQueueOfStacksChallenge() {
        //should print following output:
        //14
        //14

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(42);
        queue.dequeue();
        queue.enqueue(14);
        System.out.println(queue.peek());
        queue.enqueue(28);
        System.out.println(queue.peek());
        queue.enqueue(60);
        queue.enqueue(78);
        queue.dequeue();
        queue.dequeue();
    }



    /***********************************************
     *
     * Balanced Brackets problem: Identify if sequence of brackets
     * is balanced or not
     */

    public static void testBalancedBrackets() {
        String[] strings = {"{[()]}", "{[(])}", "{{[[(())]]}}"};
        for (String string : strings) {
            System.out.println((isBalanced(string)) ? "YES" : "NO");
        }
    }


    public static boolean isOpeningBracket(char ch) {
        return (ch == '(' || ch == '{' || ch == '[');
    }

    public static boolean isClosingBracket(char ch) {
        return (ch == ')' || ch == '}' || ch == ']');
    }

    public static boolean areSameBrackets(char opening, char closing) {
        if (opening == '(' && closing == ')') {
            return true;
        } else if (opening == '{' && closing == '}') {
            return true;
        } else if (opening == '[' && closing == ']') {
            return true;
        }

        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);
            if (isOpeningBracket(ch)) {
                stack.push(ch);
                continue;
            }

            if (isClosingBracket(ch)) {
                if (stack.empty() || !areSameBrackets(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
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
