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
        System.out.println(sumOfAllFithPowersDigits(3));
        System.out.println(sumOfAllFithPowersDigits(4));
        System.out.println(sumOfAllFithPowersDigits(5));
        System.out.println(sumOfAllFithPowersDigits(6));
    }

    static int sumOfAllFithPowersDigits(int nThPower) {
        // If a number has at least n >= 7 digits, then even if every digit is 9,
        // n * 9^5 is still less than the number (which is at least 10^n).
        int sum = 0;
        for (int i = 10; i <= 1000000; i++) {
            if (i == nTHPowerDigitsSum(i, nThPower))
                sum += i;
        }
        return sum;
    }

    static int nTHPowerDigitsSum(int x, int nThPower) {
        int sum = 0;
        while (x != 0) {
            int digit = x % 10;  // reminder of x
            sum += (int) Math.pow(digit, nThPower);
            x = x / 10;
        }
        return sum;
    }
}
