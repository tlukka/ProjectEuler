public class Problem23 {
    //NON-ABUNDANT SUMS
    //A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
    // For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
    // which means that 28 is a perfect number.

    //A number n is called deficient if the sum of its proper divisors is less than n,
    // and it is called abundant if this sum exceeds n.
    //As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as
    // the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers
    // greater than 28123 can be written as the sum of two abundant numbers. However,
    // this upper limit cannot be reduced any further by analysis even though it is known that the
    // greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.


    //Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


    static final int LIMIT = 28123;
    private static boolean[] isAbundantLookup = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        System.out.println(sumOfAbundant());
    }

    static int sumOfAbundant() {
        for (int i = 1; i < isAbundantLookup.length; i++) {
            isAbundantLookup[i] = isAbundant(i);
        }

        int sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!isSumOf2Abundant(i))
                sum += i;
        }
        return sum;
    }


    static boolean isSumOf2Abundant(int n) {
        for (int i = 0; i <= n; i++) {
            if (isAbundantLookup[i] && isAbundantLookup[n - i])
                return true;
        }
        return false;
    }

    static boolean isAbundant(int n) {
        if (n < 1)
            throw new IllegalArgumentException("Invalid input");
        int sum = 1; // Sum of factors less than n
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0)
                sum += i + n / i;
        }
        if (end * end == n) // Perfect square
            sum -= end;
        return sum > n;
    }
}
