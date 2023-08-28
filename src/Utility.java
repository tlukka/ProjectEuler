public class Utility {
    public static boolean isPrimeNumber(long n) {
        if (n == 1)
            return true;
        for (int i = 2; i < n - 1; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
