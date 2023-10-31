import java.util.Arrays;

public class Problem10 {
    // Find the sum of all the primes below two million.
    // Sum of primes below 10 is 17 -> 2+3+5+7
    // Sum of primes below 20 is 17 -> 2+3+5+7+11+13+17+19

    public static void main(String[] args) {
        System.out.println(sumOfPrimes(10));
        System.out.println(sumOfPrimes(20));
        System.out.println(sumOfPrimes(1000000));
        System.out.println(sumOfPrimes(13));

        System.out.println(primeSum(10));
        System.out.println(primeSum(20));
        System.out.println(primeSum(13));
        System.out.println(primeSum(1000000));
    }

    static long sumOfPrimes(long num) {
        long sum = 0;
        while (num-- > 0) {
            if (Utility.isPrime(num) == 1)
                sum += num;
        }
        return sum;
    }

    static long primeSum(int num) {
        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // marking 0 and 1 or non prime
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // all multiples of current prime is non-prime
            if (isPrime[i]) {
                // all squares will be non prime numbers
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < num; i++) {
            if (isPrime[i])
                sum += i;
        }

        return sum;
    }
}
