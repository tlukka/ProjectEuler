public class Problem30 {
    // DIGIT FIFTH POWERS
    // Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
    //1634 = 14 + 64 + 34 + 44 and 8208 = 84 + 24 + 04 + 84 and 9474 = 94 + 44 + 74 + 44

    //As 1 = 14 is not a sum it is not included.
    //
    //The sum of these numbers is 1634 + 8208 + 9474 = 19316.
    //
    //Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

    public static void main(String[] args) {
        System.out.println(sumOfAllFithPowersDigits());
    }

    static int sumOfAllFithPowersDigits() {
        // If a number has at least n >= 7 digits, then even if every digit is 9,
        // n * 9^5 is still less than the number (which is at least 10^n).
        int sum = 0;
        for (int i = 10; i <= 1000000; i++) {
            if (i == fifthDigitsSum(i))
                sum += i;
        }
        return sum;
    }

    static int fifthDigitsSum(int x) {
        int sum = 0;
        while (x != 0) {
            int digit = x % 10;  // reminder of x
            sum += (int)Math.pow(digit, 5);
            x = x / 10;
        }
        return sum;
    }
}
