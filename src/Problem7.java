public class Problem7 {
    // What is Nth Prime Number
    // 2,3,5,7,11,13-> 6th Prime number is 13.

    public static void main(String[] args) {
        System.out.println(nthPrimeNumber(10001));
        System.out.println(nthPrimeNumber(6));
    }

    static long nthPrimeNumber(int n) {
        long startTime = System.currentTimeMillis();
        if (n == 1)
            return 2;
        long primeNumber = 1, count = 1;
        while (count != n) {
            primeNumber += 2; // even numbers are not prime.
            if (Utility.isPrimeNumber(primeNumber))
                count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " +  (endTime - startTime));
        return primeNumber;
    }
}
