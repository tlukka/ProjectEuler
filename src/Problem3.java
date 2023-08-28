public class Problem3 {
    //Largest Prime Factor
    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143?

    // input is 2  and output is 2
    // input is 10  and output is 5 -> (2, 5)
    // input is 17 and output is 17 -> (1, 17)

    public static void main(String[] args) {
        System.out.println(largestPrimeNumber(2));
        System.out.println(largestPrimeNumber(10));
        System.out.println(largestPrimeNumber(17));
        System.out.println(largestPrimeNumber(13195));
        System.out.println(largestPrimeNumber(328513));
        System.out.println(largestPrimeNumber(25698751));

        System.out.println(maxPrimeFactors(2));
        System.out.println(maxPrimeFactors(10));
        System.out.println(maxPrimeFactors(17));
        System.out.println(maxPrimeFactors(13195));
        System.out.println(maxPrimeFactors(328513));
        System.out.println(maxPrimeFactors(25698751));
    }

    static long largestPrimeNumber(long num) {
        if (num < 2)
            return num;
        long result = 0;

        for (long i = 1; i <= num; i++)
            if (num % i == 0 && Utility.isPrimeNumber(i))
                result = i;

        return result;
    }

    static long maxPrimeFactors(long num) {
        long result = -1;
        int i = 2;
        // checking loop with i*2
        while (i * i < num) {
            while (num % i == 0) {
                result = i;
                num = num / i;
            }
            i++;
        }

        if (num > 1)
            result = num;
        return result;
    }
}
