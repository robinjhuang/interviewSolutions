public class rotateMatrix {
	/* Uses O(n^2) space and O(n^2) runtime complexity */
    public static int [][] rotate90Degrees (int [][] image, int n) {
        int limit = n / 2;
        int [] [] result = new int[n][n];

        // for odd number of rows
        if (n % 2 != 0) {
            int mid = ((n - 1) / 2); // don't need to add one because arrays start at 0
            result[mid][mid] = image[mid][mid];
        }
        // do this layer by layer, like an onion
        for (int i = 0; i < limit; ++i) {
            /* k keeps track of the number of elements in a row for each layer */

            // shift first row into last column
            for (int k = 0; k < n - 2*i; ++k) {
                result[i + k][n - i - 1] = image[i][i + k];

                // shift last column into last row
                result[n - i - 1][i + k] = image[n - i - k - 1][n - i - 1];

                // shift last row into first column
                result[i + k][i] = image[n - i - 1][i + k];

                // shift first column into first row
                result[i][n - i - k - 1] = image[i + k][i];
            }
        }

        return result;

    }

    /* Uses O(n) space and O(n^2) runtime complexity */
    public static int [][] rotate90DegreesInPlace (int [][] image, int n) {
        int limit = n / 2;
        int [] temp1 = new int[n];
        int [] temp2 = new int[n];
        int [] temp3 = new int [n];
        // do this layer by layer, like an onion
        for (int i = 0; i < limit; ++i) {
            /* k keeps track of the number of elements in a row for each layer */


            for (int k = 0; k < n - 2*i; ++k) {
                temp1[k] = image [i + k][n - i - 1]; // save last column
                temp2[k] = image [n - i - 1][i + k];// save last row
                temp3[k] = image [i + k][i];// save first column

                // shift first row into last column
                image[i + k][n - i - 1] = image[i][i + k];

                // shift last column into last row
                image[n - i - 1][i + k] = temp1[k];

                // shift last row into first column
                image[i + k][i] = temp2[k];

                // shift first column into first row
                image[i][n - i - k - 1] = temp3[k];
            }
        }

        return image;

    }
    /* BEST: Uses O(1) space and O(n^2) runtime complexity */
    public static int [][] rotate90DegreesBest (int [][] image, int n) {
        int limit = n / 2;
        int [] temp1 = new int[n];


        // do this layer by layer, like an onion
        for (int i = 0; i < limit; ++i) {

            /* k keeps track of the number of elements in a row for each layer */
            for (int k = 0; k < n - 2*i - 1; ++k) {
                int top = image[i][i + k];

                // shift first column into first row
                image[i][i + k] = image[n - 1 - i - k][i];

                // shift last row into first column
                image[n - 1 - i - k][i] = image[n - 1 - i][n - 1 - i - k];

                // shift last column into last row
                image[n - 1 - i][n - 1 - i - k] = image [i + k][n - 1 - i];

                // shift top into last column
                image[i + k][n - 1 - i] = top;
            }
        }

        return image;

    }

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

    public static void main (String [] args) {
        int [][] arr = new int [][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int [][] arr2 = new int [][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printIntArray(arr, 4); arr = rotate90DegreesBest(arr, 4); System.out.println(); printIntArray(arr, 4);
        printIntArray(arr2, 3); arr2 = rotate90DegreesBest(arr2, 3); System.out.println(); printIntArray(arr2, 3);
    
    }
		
}	



