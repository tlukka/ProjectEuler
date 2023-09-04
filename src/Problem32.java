import java.util.Arrays;

public class Problem32 {
    // PANDIGITAL PRODUCTS
    //an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
    // the 5-digit number, 15234, is 1 through 5 pandigital
    // product 7254 is unusual, as the identity, 39 [×] 186 = 7254, containing multiplicand, multiplier,
    // and product is 1 through 9 pandigital

    // Find the sum of all products whose multiplicand/multiplier/product identity
    // can be written as a 1 through 9 pandigital.

    public static void main(String[] args) {
        System.out.println(productOfPanDigital());
    }

    static int productOfPanDigital() {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            if (hasProductPanDigital(i)) {
                sum += i;
            }
        }
        return sum;
    }

    static boolean hasProductPanDigital(int n) {
        // Find and examine all factors of n
        for (int i = 1; i <= n; i++) {
            // checking i should divide n
            if (n % i == 0 && isPanDigital("" + n + i + n / i)) {
                return true;
            }
        }
        return false;
    }

    static boolean isPanDigital(String str) {
        if (str.length() != 9)
            return false;
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp).equals("123456789");
    }
}
