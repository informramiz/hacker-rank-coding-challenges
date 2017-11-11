/**
 * Created by ramiz on 11/11/17.
 */
public class SortingAlgorithms {
    public static void bubbleSort(int[] arr) {
        int totalSwapsCount = 0;
        int unsortedArrayLength = arr.length - 1;
        boolean isSorted = false;
        while(!isSorted) {
            int singleIterationSwaps = 0;
            for (int i = 0; i < unsortedArrayLength; ++i) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    singleIterationSwaps++;
                }
            }

            totalSwapsCount += singleIterationSwaps;
            if (singleIterationSwaps == 0) {
                isSorted = true;
            }

            unsortedArrayLength--;
        }

        System.out.printf("Array is sorted in %d swaps.\n", totalSwapsCount);
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length-1]);
    }

    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }

        int pivot = a[(left + right) / 2];
        int index = partition(a, left, right, pivot);
        quickSort(a, left, index - 1);
        quickSort(a, index, right);
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        while (left <= right) {
            while (a[left] < pivot) {
                left++;
            }

            while (a[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }

        return left;
    }
}
