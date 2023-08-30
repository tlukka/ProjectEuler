public class Problem15 {
    //Starting in the top left corner of a grid, and only being able to move to the right and down,
    // there are exactly 6 routes to the bottom right corner.
    // How many such routes are there through a 20*20 grid


    // n choose k combinations. -> nCk formula is => n!/k!*(n-k)!
    public static void main(String[] args) {
        System.out.println(getLatticePath(20, 20));
        System.out.println(getLatticePathByMemory(20, 20));
    }

    static String getLatticePath(int gridRowLength, int gridColumnLength) {
        long startTime = System.currentTimeMillis();
        String latticePathCount = Utility.bionimalCofficent(gridRowLength + gridColumnLength, gridColumnLength).toString();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return latticePathCount;
    }

    static String getLatticePathByMemory(int height, int width) {
        long startTime = System.currentTimeMillis();
        long[][] map = new long[height + 1][width + 1];
        //initialise all top and left most cells 1
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (r == 0 || c == 0)
                    map[r][c] = 1;
                else
                    map[r][c] = 0;
            }
        }
        //sum all intersection points up
        for (int row = 1; row < map.length; row++) {
            for (int col = 1; col < map[0].length; col++) {
                map[row][col] = map[row][col - 1] + map[row - 1][col];
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return String.valueOf(map[height][width]);
    }
}
