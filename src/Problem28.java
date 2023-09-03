public class Problem28 {
    // 5*5 spiral matrix diagonals is 101
    // What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


    public static void main(String[] args) {
        System.out.println(sumDiagonalsInMatrix(4));
        System.out.println(sumDiagonalsInMatrix(8));
        System.out.println(sumDiagonalsInMatrix(1000));
        System.out.println(sumDiagonalsInMatrixWithFormula(5));
        System.out.println(sumDiagonalsInMatrixWithFormula(9));
        System.out.println(sumDiagonalsInMatrixWithFormula(1001));
    }

    static int sumDiagonalsInMatrix(int matrixSize) {
        //notice that the diagonals start with 1, then 3,5,7,9 with constant difference 2
        //then +4 to another set of 4 numbers 13,17,21,25 with constant difference 4
        //then +6 to another set of 4 numbers 31,37,43,49
        //Also notice that the largest number is the size of the array squared
        //E.g. 5x5 grid max number is 5^2 = 25
        int sum = 1;
        int constantSize = 2, count = 0;
        long maxSize = (matrixSize + 1) * (matrixSize + 1);
        for (int i = 3; i <= maxSize; i += constantSize) {
            sum += i;
            count++;
            if (count == 4) {
                count = 0;
                constantSize += 2;
            }
        }
        return sum;
    }

    static long sumDiagonalsInMatrixWithFormula(int matrixSize) {
      /*
     From the diagram, let's observe the four corners of an n * n square (where n is odd).
     It's not hard to convince yourself that the top right corner always has the value n^2.
     Working counterclockwise (backwards), the top left corner has the value n^2 - (n - 1),
     the bottom left corner has the value n^2 - 2(n - 1), and the bottom right is n^2 - 3(n - 1).
     Putting it all together, this outermost ring contributes 4n^2 - 6(n - 1) to the final sum.
     Incidentally, the closed form of this sum is (4m^3 + 3m^2 + 8m - 9) / 6, where m = size.
     */

        long sum = 1;
        for (int i = 3; i <= matrixSize; i += 2) {
            sum += ((4 * i * i) - 6 * (i - 1));
        }
        return sum;
    }


}
