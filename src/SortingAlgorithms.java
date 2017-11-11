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

    public static long mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        return mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static long mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int middle = (left + right) / 2;
        long swapsCount = mergeSort(a, tmpArray, left, middle);
        swapsCount += mergeSort(a, tmpArray, middle + 1, right);
        return swapsCount + mergeHalves(a, tmpArray, left, right);
    }

    private static long mergeHalves(int[] a, int[] tmpArray, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int index = leftStart;
        int left = leftStart;
        int right = rightStart;
        long swapsCount = 0;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left] <= a[right]) {
                tmpArray[index] = a[left];
                left++;
            } else {
                tmpArray[index] = a[right];
                //number of swaps is the distance between right value index
                //and the index where it is being moved to
                swapsCount += right - index;
                right++;
            }

            index++;
        }

        //copy remaining elements
        System.arraycopy(a, left, tmpArray, index, leftEnd - left + 1);
        System.arraycopy(a, right, tmpArray, index, rightEnd - right + 1);

        //copy elements back
        System.arraycopy(tmpArray, leftStart, a, leftStart, size);

        return swapsCount;
    }
}
