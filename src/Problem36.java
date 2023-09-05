public class Problem36 {
    // DOUBLE-BASE PALINDROMES
    // decimal number, 585 = 1001001001 -> palindromic in base 10 and base 2
    // Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2


    public static void main(String[] args) {
        System.out.println(sumOfAllBasePalindromes());
    }

    static long sumOfAllBasePalindromes() {
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            // Convert Base 10 to Base 2 -> Integer.toBinaryString(i) or Integer.toString(i, 2)
            //Utility.isPalindromString(Integer.toString(i)) && Utility.isPalindromString(Integer.toString(i, 2))
            if (Utility.isPalindrome(Integer.toString(i)) && Utility.isPalindrome(Integer.toString(i, 2))) {
                sum += i;
            }
        }
        return sum;
    }
}
