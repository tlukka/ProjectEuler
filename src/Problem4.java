public class Problem4 {
    // Largest Palindrome product of two 3 digits number which are less than N
    // input 101110 and o/p: 101101 -> product of 143 * 707
    // i/p 800000 and o/p: 793397 -> product of 869 * 913

    public static void main(String[] args) {
        System.out.println(largestPalindromeBruteForce(101110));
        System.out.println(largestPalindromeBruteForce(800000));
    }

    static long largestPalindromeBruteForce(int num) {
        // travel from highest to lowest in 3 digits
        for (int i = 999; i > 100; i--) {
            for (int j = 999; j > 100; j--) {
                int largest = i * j;
                if(num < largest)
                    continue;
                if (isPalindrome(largest)) {
                    System.out.println("Product of Larest palindrome and numbers are " + i + "," + j);
                    return largest;
                }
            }
        }
        return -1;
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
