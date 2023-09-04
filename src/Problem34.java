public class Problem34 {
    // DIGIT FACTORIALS
    // 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
    //Find the sum of all numbers which are equal to the sum of the factorial of their digits.
    //Note: as 1! = 1 and 2! = 2 are not sums they are not included.

    public static void main(String[] args) {
        System.out.println(sumOfFactorialsOfDigits());
    }

    static int[] FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; // factorials of 1 to 9

    static int sumOfFactorialsOfDigits() {
        int sum = 0;
        for (int i = 3; i < 10000000; i++) {
            if (isFactorialDigitsSumEquals(i)) {
                sum += i;
            }
        }
        return sum;
    }

    static boolean isFactorialDigitsSumEquals(int n) {
        int temp = n;
        int sum = 0;
        while (n != 0) {
            sum += FACTORIALS[n % 10];
            n = n / 10;
        }
        return sum == temp;
    }
}
