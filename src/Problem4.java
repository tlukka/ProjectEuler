import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem4 {
    // Largest Palindrome product of two 3 digits number which are less than N
    // input 101110 and o/p: 101101 -> product of 143 * 707
    // i/p 800000 and o/p: 793397 -> product of 869 * 913

    public static void main(String[] args) {
        System.out.println(largestPalindromeNativeApproach(101110));
        System.out.println(largestPalindromeNativeApproach(800000));
        System.out.println(largestPalindromeProductNDigits(2));
        System.out.println(largestPalindromeProductNDigits(3));
        System.out.println(largestPalindromeProductNDigits(4));
        System.out.println(longestPalindromeWithOptimize(101110));
        System.out.println(longestPalindromeWithOptimize(800000));
    }

    // Function to calculate largest palindrome which isproduct of two n-digits numbers
    static long largestPalindromeProductNDigits(int n) {
        int upperLimit = (int) (Math.pow(10, n) - 1);
        int lowerLimit = 1 + upperLimit / 10;
        for (int i = upperLimit; i >= lowerLimit; i--) {
            for (int j = i; j >= lowerLimit; j--) {
                long product = i * j;
                if (isPalindrome(product)) {
                    System.out.println("Product of Largest palindrome and numbers are " + i + "," + j);
                    return product;
                }
            }
        }
        return -1;
    }

    static long longestPalindromeWithOptimize(int num) {
        int step = 1;
        List<Long> palindromesList = new ArrayList<>();
        for (int i = 990; i >= 100; i--) {
            int j = 0;
            if (i % 11 == 0) {
                step = 1;
                j = i;
            } else {
                step = 11;
                j = i - i % 11;
            }
            for (; j >= 100; j = j - step) {
                long product = i * j;
                if (isPalindrome(product) && product < num) {
                    palindromesList.add(product);
                }
            }
        }
        return Collections.max(palindromesList);
    }

    static long largestPalindromeNativeApproach(int num) {
        // travel from highest to lowest in 3 digits
        List<Long> palindromesList = new ArrayList<>();
        for (int i = 999; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                long product = i * j;
                if (isPalindrome(product) && product < num) {
                    palindromesList.add(product);
                }
            }
        }
        return Collections.max(palindromesList);
    }


    static boolean isPalindrome(long n) {
        char[] charrArray = ("" + n).toCharArray();
        int len = charrArray.length;
        for (int i = 0; i < len; i++) {
            if (charrArray[i] != charrArray[len - i - 1])
                return false;
        }
        return true;
    }

}
