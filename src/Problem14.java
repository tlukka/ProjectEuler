import java.math.BigInteger;

public class Problem14 {
    // The following iterative sequence is defined for the set of positive integers:
    //n [→] n/2 (n is even)
    //n [→] 3n + 1 (n is odd)
    //Using the rule above and starting with 13, we generate the following sequence:
    //13 [→] 40 [→] 20 [→] 10 [→] 5 [→] 16 [→] 8 [→] 4 [→] 2 [→] 1
    //It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    // Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
    //Which starting number, under one million, produces the longest chain?

    //NOTE: Once the chain starts the terms are allowed to go above one million.

    public static void main(String[] args) {
        System.out.println(getCollatzNumberInMillion());
        System.out.println(getCollatzNumber());
    }

    static long LIMIT = (long) Math.pow(10, 6);
    static BigInteger CACHE_SIZE = BigInteger.valueOf(LIMIT); // Non-Negative numbers returned
    static int[] collatzChainLengthArray = new int[CACHE_SIZE.intValue()]; // Memoization


    static int getCollatzNumberInMillion() {
        long startTime = System.currentTimeMillis();
        int maxArg = -1;
        int maxChain = 0;
        for (int i = 1; i < LIMIT; i++) {
            int chainLen = getCollatzLength(BigInteger.valueOf(i));
            if (chainLen > maxChain) {
                maxChain = chainLen;
                maxArg = i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return Integer.valueOf(maxArg);
    }

    static int getCollatzLength(BigInteger n) {
        if (n.signum() < 0)
            throw new IllegalArgumentException("Invalid argument");

        if (n.compareTo(CACHE_SIZE) >= 0)
            return collatzChainLengthDirect(n);

        int index = n.intValue(); // index of value
        if (collatzChainLengthArray[index] == 0)
            collatzChainLengthArray[index] = collatzChainLengthDirect(n);

        return collatzChainLengthArray[index];
    }

    // Returns the Collatz chain length of the given integer with the first step uncached
    // but the remaining steps using automatic caching.
    static int collatzChainLengthDirect(BigInteger n) {
        // Base case
        if (n.equals(BigInteger.ONE))
            return 1;
        else if (!n.testBit(0)) { // when even
            return getCollatzLength(n.shiftRight(1)) + 1;
        } else {
            return getCollatzLength(n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE)) + 1;
        }
    }

    static int getCollatzNumber() {
        long startTime = System.currentTimeMillis();
        int length = 0;
        int tempLen = 0;
        int longNum = 0;
        for (int i = 1; i < 1000000; i++) {
            tempLen = getCountCollatz(i);
            if (tempLen > length) {
                length = tempLen;
                longNum = i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime));
        return longNum;
    }

    static int getCountCollatz(long a) {
        int count = 1;
        while (a != 1) {
            if (a % 2 == 0)
                a /= 2;
            else
                a = 3 * a + 1;

            count++;
        }

        return count;
    }

}
