import java.math.BigInteger;
import java.util.Arrays;

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
        // 1,2,3,5,7,13,19,23,29...
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return 0;
        }
        return 1;
    }

    // Returns a Boolean array 'isPrime' where isPrime[i] indicates whether i is prime, for 0 <= i <= n.
    // For a large batch of queries, this is faster than calling isPrime() for each integer.
    // For example: listPrimality(100) = {false, false, true, true, false, true, false, true,
    // false, false, false, true, false, true, false, false, false, true, ...} (array length 101).
    public static boolean[] listPrimality(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Negative array size");
        boolean[] result = new boolean[n + 1];
        if (n >= 2)
            result[2] = true;
        for (int i = 3; i <= n; i += 2)
            result[i] = true;
        // Sieve of Eratosthenes
        for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
            if (result[i]) {
                // Note: i * i does not overflow
                for (int j = i * i, inc = i * 2; j <= n; j += inc)
                    result[j] = false;
            }
        }
        return result;
    }

    public static int[] listPrimes(int n) {
        boolean[] isPrime = listPrimality(n);
        int count = 0;
        for (boolean b : isPrime) {
            if (b)
                count++;
        }

        int[] result = new int[count];
        for (int i = 0, j = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                result[j] = i;
                j++;
            }
        }
        return result;
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

    public static int divisorSum(long num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return sum;
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
        if (n < 0 || r < 0)
            throw new IllegalArgumentException("Invalid inputs");
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }


    static boolean nextPermutation(int[] arr) {
        // assuming array starts with the lowest number
        // find array non-increasing suffix
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0)
            return false;
        // find rightmost element greater than the pivot
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        // Swap the elements of pivot and j values
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        // Reverse the suffix
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    static long nextFibonacci(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        int i = 1;
        while (i++ < n)
            nums[i] = nums[i - 1] + nums[i - 2];


        return nums[n];
    }

    static int gcd(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Negative numbers");
        while (y != 0) {
            int z = x % y;
            x = y;
            y = z;
        }
        return x;
    }

    static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }


    static boolean isPalindromString(String x) {
        char[] arr = x.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1])
                return false;
        }
        return true;
    }


    public static boolean isPanDigital(String str) {
        if (str.length() != 9)
            return false;
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp).equals("123456789");
    }
}
