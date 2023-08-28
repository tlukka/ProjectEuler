import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    // What is Nth Prime Number
    // 2,3,5,7,11,13-> 6th Prime number is 13.

    public static void main(String[] args) {
        System.out.println(nthPrimeNumber(10001));
        System.out.println(nthPrimeNumber(6));
        System.out.println(nthPrimer(10001));
        System.out.println(nthPrimer(6));
    }

    // Optimized way of implementation
    static long nthPrimeNumber(int n) {
        long startTime = System.currentTimeMillis();
        if (n == 1)
            return 2;
        long primeNumber = 1, count = 1;
        while (count != n) {
            primeNumber += 2; // even numbers are not prime.
            // if (Utility.isPrimeNumber(primeNumber)) -> takes lot of time.
            if (Utility.isPrime(primeNumber) == 1)
                count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return primeNumber;
    }

    // Taking more time with array approach.
    static long nthPrimer(int n) {
        long startTime = System.currentTimeMillis();
        int MAX_SIZE = 1000005;
        boolean[] isPrimes = new boolean[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            isPrimes[i] = true;
        }
        for (int p = 2; p * p < MAX_SIZE; p++) {
            // if isPrimes[p] is not changed then it is prime
            if (isPrimes[p] == true) {
                // Update all multiples of p greater than or equal to the square of it
                // numbers which are multiple of p and are less than p^2 are already been marked.
                for (int i = p * p; i < MAX_SIZE; i += p)
                    isPrimes[i] = false;
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int p = 2; p < MAX_SIZE; p++)
            if (isPrimes[p] == true)
                primes.add(p);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return primes.get(n-1);
    }
}
