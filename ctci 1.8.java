public class zeroMatrix {
	public static void printIntArray(int [][] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; ++j) {
                if (j + 1 != n) {
                    System.out.print(arr[i][j]);
                    System.out.print(", ");
                }
                else
                    System.out.print(arr[i][j]);
            }
            System.out.println("]");
        }
    }
    // Time complexity of O(m x n), Space complexity of O(m + n)
    public static int[][] zeroThisMatrix(int [][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        Set<Integer> zeroThisRow = new HashSet<Integer>(m);
        Set<Integer> zeroThisCol = new HashSet<Integer>(n);

        for (int i = 0; i < m; ++i) {
            if (!zeroThisRow.contains(i)) {
                for (int j = 0; j < n; ++j) {
                    if (arr[i][j] == 0 && !zeroThisCol.contains(j)) {
                        zeroThisRow.add(i);
                        zeroThisCol.add(j);
                    }
                }
            }
        }

        Iterator rowIter = zeroThisRow.iterator();
        while (rowIter.hasNext()) {
            int row = (int)rowIter.next();
            for (int i = 0; i < n; ++i)
                arr[row][i] = 0;
        }

        Iterator colIter = zeroThisCol.iterator();
        while(colIter.hasNext()) {
            int col = (int)colIter.next();
            for (int i = 0; i < m; ++i)
                arr[i][col] = 0;
        }

        return arr;
    }

    // Time complexity of O(m x n), Space complexity of O(1)
    // Assumes we only have positive integers in the initial array
    public static int[][] zeroThisMatrixBest(int [][] arr) {
        int m = arr.length;
        int n = arr[0].length;


        for (int i = 0; i < m; ++i) {

            for (int j = 0; j < n; ++j) {
                if (arr[i][j] == 0) {
                    arr[i][j] = -1;

                }
            }

        }

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j) {
                if (arr[i][j] == -1) {
                    // zero row
                    for (int x = 0; x < n; ++x)
                        arr[i][x] = 0;
                    // zero col
                    for (int y = 0; y < m; ++y)
                        arr[y][j] = 0;
                }

            }
        }

        return arr;
    }

    public static void main (String [] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 0, 8},
                {9, 10, 11, 12},
                {0, 14, 15, 16}
        };

        int[][] arr2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        arr = zeroThisMatrixBest(arr);
        printIntArray(arr, 4);
    }

}
