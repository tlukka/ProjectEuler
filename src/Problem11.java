public class Problem11 {
    // Largest product in grid with adjust cells (up, down, left, right, or diagonally).

    public static void main(String[] args) {
        System.out.println(maxProductInGrid(SQUARE1));
        System.out.println(maxProductInGrid(SQUARE2));
        System.out.println(maxProductInGrid(SQUARE));
         int[][] a = new int[][]{
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 1},
                {2, 3, 4, 5, 6}, {7, 8, 9, 1, 0},
                {9, 6, 4, 2, 3}, {1, 1, 2, 1, 1}
        };
        // System.out.println(maxProductInAdjustCell(SQUARE1, SQUARE1.length + 1, (SQUARE1[0].length) + 1, 4));
        // System.out.println(maxProductInAdjustCell(SQUARE2, SQUARE2.length + 1, (SQUARE2[0].length) + 1, 4));
        int row = a.length, col = a[0].length;
        int row1 = SQUARE.length, col1 = SQUARE[0].length;
        int row2 = SQUARE2.length, col2 = SQUARE2[0].length;
        System.out.println(maxProductInAdjustCell(a, row, col, 4));
        System.out.println(maxProductInAdjustCell(SQUARE, row1, col1, 4));
        System.out.println(maxProductInAdjustCell(SQUARE2, row2, col2, 3));
    }

    static int[][] SQUARE1 = {
            {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
            {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
            {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
            {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
            {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
            {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
            {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
            {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
            {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
            {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
            {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
            {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
            {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
            {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
            {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
            {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
            {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
            {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
            {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
            {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48},
    };

    static int[][] SQUARE2 = {{6, 2, 3, 4},
            {5, 4, 3, 1},
            {7, 4, 5, 6},
            {8, 3, 1, 0}};
    static int[][] SQUARE = {{1, 2, 3, 4, 5},
            {6, 7, 8, 9, 1},
            {2, 3, 4, 5, 6},
            {7, 8, 9, 1, 0},
            {9, 6, 4, 2, 3}};
    static final int CONSECUTIVE = 4;

    static long maxProductInGrid(int[][] arrSquare) {
        long max_Prod = -1;
        int rowLen = arrSquare.length;
        for (int y = 0; y < rowLen; y++) {
            int colLen = arrSquare[y].length;
            for (int x = 0; x < colLen; x++) {
                max_Prod = Math.max(product(x, y, 1, 0, CONSECUTIVE, rowLen, colLen, arrSquare), max_Prod);
                max_Prod = Math.max(product(x, y, 0, 1, CONSECUTIVE, rowLen, colLen, arrSquare), max_Prod);
                max_Prod = Math.max(product(x, y, 1, 1, CONSECUTIVE, rowLen, colLen, arrSquare), max_Prod);
                max_Prod = Math.max(product(x, y, 1, -1, CONSECUTIVE, rowLen, colLen, arrSquare), max_Prod);
            }
        }
        return max_Prod;
    }

    static boolean isInBounds(int x, int y, int rowLen, int colLen) {
        // boundary check between 0 to length of array
        return 0 <= y && y < rowLen && 0 <= x && x < colLen;
    }

    static int product(int x, int y, int dx, int dy, int n, int rowLen, int colLen, int[][] arr) {
        // First endpoint is assumed to be in bounds. Check if second endpoint is in bounds.
        if (!isInBounds(x + (n - 1) * dx, y + (n - 1) * dy, rowLen, colLen)) {
            return -1;
        }
        int prod = 1;
        for (int i = 0; i < n; i++, x += dx, y += dy) {
            prod *= arr[y][x];
        }
        return prod;
    }


    // Sliding Window apporach
    static long maxProductInAdjustCell(int[][] arr, int row, int col, int k) {
        long max_Product = 1, maxProdctResult = 1;
        for (int i = 0; i < row; i++) {
            // Window Product for each row with digits.
            int wp = 1;
            for (int j = 0; j < k; j++) {
                wp *= arr[i][j];
            }
            // Maximum window product for each row
            max_Product = wp;
            for (int l = k; l < col; l++) {
                int currentCell = arr[i][l];
                int firstCellInPreviousWindow = arr[i][l - k];
                wp = (wp * currentCell) / firstCellInPreviousWindow;
                // Global maximum window product
                maxProdctResult = Math.max(maxProdctResult, Math.max(wp, max_Product));
            }
        }

        return maxProdctResult;
    }
}
