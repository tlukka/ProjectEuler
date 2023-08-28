public class Problem5 {
    // What is the smallest number that can divisible by all numbers from 1 to N
    // 2520 is the smallest number that can be divided by all numbers from 1 to 10 ->
    // {1,2,3,4,5,6,7,8,9,10} with quotient {2520, 1260,840, 630, 504,420, 360,315,280,252}
    // 6 is divisible of 1,2,3
    public static void main(String[] args) {
        System.out.println(smallestLcm(2));
        System.out.println(smallestLcm(3));
        System.out.println(smallestLcm(4));
        System.out.println(smallestLcm(10));
        System.out.println(smallestLcm(20));
    }

    // GCD
    static long greatestCommonDivisor(long a, long b) {
        if (b != 0) {
            return greatestCommonDivisor(b, a % b);
        } else {
            return a;
        }
    }

    //// Function returns the lcm of first n numbers
    static long smallestLcm(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) / (greatestCommonDivisor(ans, i));
        }
        return ans;
    }


}
