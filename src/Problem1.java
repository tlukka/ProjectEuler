public class Problem1 {
    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    // The sum of these multiples is 23.
    // Find the sum of all the multiples of $3 or $5 below $1000

    public static void main(String[] args) {
        System.out.println(sumOfDivideBy3And5(10));
        System.out.println(sumOfDivideBy3And5(100));
        System.out.println(sumOfDivideBy3And5Optimize(10));
        System.out.println(sumOfDivideBy3And5Optimize(100));
    }

    static int sumOfDivideBy3And5(int target) {
        int result = 0;
        if (target == 0) return result;
        for (int i = 0; i < target; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }

    static int sumOfDivideBy3And5Optimize(int target) {
        //sum of all numbers smaller than a divisible by 3 or 5 is the same as
        //+ the sum of all numbers smaller than `a` divisible by `3`
        //+ the sum of all numbers smaller than `a` divisible by `5`
        //- the sum of all numbers smaller than `a` divisible by `15`
        return sumByKnumber(target,3) + sumByKnumber(target, 5) - sumByKnumber(target, 15);
    }

    static int sumByKnumber(int target, int k) {
        //There are m = (a - 1) / k numbers below a that are divisible by k (with integer division).
        // sum is m * (m + 1) / 2 * k
        int m = (target - 1) / k;
        return ((m * (m + 1)) / 2) * k;
    }

}
