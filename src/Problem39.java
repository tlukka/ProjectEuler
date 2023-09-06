public class Problem39 {
    // INTEGER RIGHT TRIANGLES
    // If p is the perimeter of a right angle triangle with integral length sides,
    // {a,b,c}, there are exactly three solutions for p = 120.
    //
    //{20,48,52}, {24,45,51}, {30,40,50}
    //
    //For which value of p [≤] 1000, is the number of solutions maximised?

    public static void main(String[] args) {
        System.out.println(maxTrianglesPerimeter());
    }

    static int maxTrianglesPerimeter() {
        int maxTriangles = 0, maxPerimeter = 0;
        for (int i = 1; i <= 1000; i++) {
            int trianglesCount = countTriangles(i);
            if (maxTriangles < trianglesCount) {
                maxTriangles = trianglesCount;
                maxPerimeter = i;
            }
        }
        System.out.println(maxTriangles);
        return maxPerimeter;
    }

    static int countTriangles(int p) {
        int count = 0;
        for (int a = 1; a <= p; a++) {
            for (int b = 1; b <= p; b++) {
                int c = p - a - b;
                if (b <= c && (a * a + b * b == c * c))
                    count++;
            }
        }
        return count;
    }
}
