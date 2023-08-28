public class Problem6 {
    // Find difference between sum of sqaures and sqaures of sum
    // Sum of Squares 1*2 + 2*2+ 3*2 -> 14
    // Squares of Sum (1+2+3)*2 -> 36
    // Difference : 36-14 => 22.


    public static void main(String[] args) {
       /* System.out.println(sumSquareDiff(3));
        System.out.println(sumSquareDiff(10));
        System.out.println(sumSquareDiff(100)); */
        System.out.println(sumOfSquareDifferInPair(new int[]{2, 8, 4}));
        System.out.println(sumOfSquareDifferInPair(new int[]{-5, 8, 9, -4, -3}));
        System.out.println(sumOfSquareDifferInPairO2(new int[]{2, 8, 4}));
        System.out.println(sumOfSquareDifferInPairO2(new int[]{-5, 8, 9, -4, -3}));
    }

    static long sumSquareDiff(int n) {
        /*long sumOfSquares = 0;
        for (int i = 1; i <= n; i++) {
            sumOfSquares += i * i;
        } */
        long sumOfSquares = (n * (n + 1) * (2 * n + 1)) / 6;
        long squaresOfSum = (long) Math.pow(n * (n + 1) / 2, 2);
        return Math.abs(squaresOfSum - sumOfSquares);
    }

    // Sum of squares of differences between all pairs of an array
    static long sumOfSquareDifferInPair(int[] arr) {
        // (A – B)2 = A2 + B2 – 2 * A * B
        //As 1/2*(∑i=1n ∑j=1n (Ai2 + Aj2 – 2*Ai*Aj)) = 1/2 * (2*n*∑i=1n Ai2  – 2*∑i=1n (Aj * ∑j=1n Aj))
        // n*∑i=1n Ai2 – (∑i=1nAi)2
        long sumA = 0, sumB = 0;
        for (int i = 0; i < arr.length; i++) {
            sumA += arr[i] * arr[i];
            sumB += arr[i];
        }
        return arr.length * sumA  - sumB * sumB;
    }

    // Sum of squares of differences between all pairs of an array
    static long sumOfSquareDifferInPairO2(int[] arr) {
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[i] - arr[j];
                result += diff * diff;
            }
        }
        return result;
    }
}
