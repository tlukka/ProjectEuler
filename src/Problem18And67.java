import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem18And67 {
    // By starting at the top of the triangle below and moving to adjacent numbers on the row below,
    // the maximum total from top to bottom is 23.

    //3
    //7 4
    //2 4 6
    //8 5 9 3
    //
    //That is, 3 + 7 + 4 + 9 = 23.
    //
    //Find the maximum total from top to bottom of the triangle below:

    public static void main(String[] args) {
        System.out.println(getMaxSum("0018_triangle.txt"));
        System.out.println(getMaxSum("0067_triangle.txt"));
    }

    static long getMaxSum(String filePath) {
        try {
            File file = new File("src/" +filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            long[][] triangle = new long[1000][1000];
            int row = 0;
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] nums = line.split(" ");
                for (int col = 0; col < nums.length; col++) {
                    triangle[row][col] = Long.parseLong(nums[col]);
                }
                row++;
            }

            // Work from bottom to top for sum
            // If we start at a particular cell, what is the maximum path total? If the cell is at the
            //	bottom of the big triangle, then it is simply the cell's value. Otherwise the answer is
            //	 the cell's value plus either {the maximum path total of the cell down and to the left}
            //	  or {the maximum path total of the cell down and to the right}, whichever is greater.
            //	  By computing the blank triangle's values from bottom up, the dependent values are always
            //	  computed before they are utilized
            for (int r = triangle.length - 2; r >= 0; r--) {
                for (int col = 0; col < triangle[r].length - 1; col++) {
                    triangle[r][col] += Math.max(triangle[r + 1][col], triangle[r + 1][col + 1]);
                }
            }

            return triangle[0][0];
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
