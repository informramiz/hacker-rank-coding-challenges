/**
 * Created by ramiz on 11/12/17.
 */
public class SearchAlgorithms {
    public static int binarySearch(int[] array, int searchKey) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (array[middle] == searchKey) {
                return middle;
            } else if (searchKey < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
