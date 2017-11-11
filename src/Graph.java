/**
 * Created by ramiz on 11/12/17.
 */
public class Graph {
    public static int getConnectedCellsCount(int[][] matrix, int[][] visited, int i, int j) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) {
            return 0;
        } else if (visited[i][j] == 1) {
            return 0;
        } else if (matrix[i][j] == 0) {
            return 0;
        }

        visited[i][j] = 1;
        int count = 1;
        count += getConnectedCellsCount(matrix, visited, i+1, j);
        count += getConnectedCellsCount(matrix, visited, i, j+1);
        count += getConnectedCellsCount(matrix, visited, i+1, j+1);
        count += getConnectedCellsCount(matrix, visited, i-1, j);
        count += getConnectedCellsCount(matrix, visited, i, j-1);
        count += getConnectedCellsCount(matrix, visited, i-1, j-1);
        count += getConnectedCellsCount(matrix, visited, i-1, j+1);
        count += getConnectedCellsCount(matrix, visited, i+1, j-1);

        return count;
    }

    public static int getBiggestRegion(int[][] matrix) {
        int maxCount = 0;
        int visited[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                int count = getConnectedCellsCount(matrix, visited, i, j);

                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }

        return maxCount;
    }
}
