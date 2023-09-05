public class Problem37 {
    // TRUNCATABLE PRIMES
    // The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
    // digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
    // Similarly we can work from right to left: 3797, 379, 37, and 3.
    //Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
    //NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

    public static void main(String[] args) {
        System.out.println(sumOfTruncatablePrimes());
    }

    static int sumOfTruncatablePrimes() {
        int sum = 0;
        for (int count = 0, n = 10; count < 11; n++) {
            if (isTruncatablePrime(n)) {
                sum += n;
                count++;
            }
        }
        return sum;
    }

    static boolean isTruncatablePrime(int n) {
        String str = Integer.toString(n);
        int len = str.length();
        // left to right
        for (int j = 0; j <= len - 1; j++) {
            //  trim from left to right or trim right to left.
            if (Utility.isPrime(Long.parseLong(str.substring(j))) != 1 || Utility.isPrime(Long.parseLong(str.substring(0, len - j))) != 1)
                return false;
        }
        return true;

        /*

        // Left Truncatable Prime check
        for (int i = 10; i <= n; i *= 10) {
            if (Utility.isPrime(n % i) != 1) {
                return false;
            }
        }

        // Right Truncatable Prime check
        for (; n != 0; n /= 10) {
            if (Utility.isPrime(n) != 1) {
                return false;
            }
        }
        return true;

         */
    }


}
