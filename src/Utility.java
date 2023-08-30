import java.math.BigInteger;

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


    static BigInteger factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Factorial of negative number");
        BigInteger product = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }

        return product;
    }

    // bionimal cofficent
    static BigInteger bionimalCofficent(int n, int r) {
        if(n<0 || r<0)
            throw new IllegalArgumentException("Invalid inputs");
        return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
    }
}
