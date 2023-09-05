public class Problem35 {
    // CIRCULAR PRIMES
    // 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
    //There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
    //How many circular primes are there below one million?

    public static void main(String[] args) {
        System.out.println(countOfCircularPrimes());
    }

    static int LIMIT = (int) Math.pow(10, 6);
    static boolean[] isPrimesArray = Utility.listPrimality(LIMIT);

    static int countOfCircularPrimes() {

        int count = 0;
        for (int i = 0; i < LIMIT - 1; i++) {
            if (isCircularPrime(i))
                count++;
        }
        return count;
    }

    static boolean isCircularPrime(int n) {
        String strI = Long.toString(n);
        for (int j = 0; j < strI.length(); j++) {
            // check circular prime condition
            if (!isPrimesArray[Integer.parseInt(strI.substring(j) + strI.substring(0, j))])
                return false;
        }
        return true;
    }
}
