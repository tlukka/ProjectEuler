public class Problem41 {
    // Find the largest prime number whose base-10 digits are a permutation of (1, 2, 3, 4, 5, 6, 7, 8, 9).
    // We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
    // For example, 2143 is a 4-digit pandigital and is also prime.

    //What is the largest n-digit pandigital prime that exists?

    public static void main(String[] args) {
        System.out.println(nThPanDigitalPrime(9));
        System.out.println(nThPanDigitalPrime(8));
        System.out.println(nThPanDigitalPrime(7));
        System.out.println(nThPanDigitalPrime(6));
        System.out.println(nThPanDigitalPrime(5));
        System.out.println(nThPanDigitalPrime(4));
    }

    static String nThPanDigitalPrime(int numDigits) {
        //Initialize
        for (int n = numDigits; n >= 1; n--) {
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) {
                digits[i] = i + 1;
            }
            int result = -1;
            do {
                int num = toInteger(digits);
                if (Utility.isPrime(num) == 1)
                    result = num;
            } while (Utility.nextPermutation(digits));
            if (result != -1)
                return Integer.toString(result);
        }
        throw new RuntimeException("Not found");
    }

    static int toInteger(int[] digits) {
        int result = 0;
        for (int x : digits)
            result = result * 10 + x;

        return result;
    }
}
