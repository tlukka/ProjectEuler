public class Utility {
    public static boolean isPrimeNumber(long n) {
        if (n == 1)
            return true;
        for (int i = 2; i < n - 1; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static int isPrime(long n) {
        // corner case
        if (n <= 1) return 0;
        if (n == 2 || n == 3) return 1;

        // below 5 there is only two prime numbers 2 and 3
        if (n % 2 == 0 || n % 3 == 0)
            return 0;

        // concept of prime number can be represented in form of (6*k + 1) or(6*k - 1)
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return 0;
        }
        return 1;
    }

    public static int divisorCount(long num) {
        int divisorCount = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                divisorCount++;
            long anotherFactor = num / i;
            if (anotherFactor != i)
                divisorCount++;
        }
        return divisorCount;
    }
}
