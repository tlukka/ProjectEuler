public class Problem17 {
    // Number Letter Counts
    // If the numbers 1 to 5 are written out in words: one, two, three, four, five,
    // then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

    // If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
    // how many letters would be used?


    // NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
    // (one hundred and fifteen) contains 20 letters.
    // The use of "and" when writing out numbers is in compliance with British usage.


    public static void main(String[] args) {
        System.out.println(numToEnglish(13));
        System.out.println(numToEnglish(83));
        System.out.println(numToEnglish(70));
        System.out.println(numToEnglish(342));
        System.out.println(numToEnglish(115));
        System.out.println(numToEnglish(1000));
        System.out.println(numLetterCount(342));
        System.out.println(numLetterCount(115));
        System.out.println(numLetterCount(1000));
    }

    static String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    static int numLetterCount(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numToEnglish(i).length();
        }
        return sum;
    }

    static String numToEnglish(int n) {
        if (n < 0 || n > 99999)
            throw new IllegalArgumentException("input is not in the valid range");
        if (n < 100) {
            return getNumberWords(n);
        } else {
            String words = "";
            if (n >= 1000) {
                words += getNumberWords(n / 1000) + " thousand ";
            }
            if (n / 100 % 10 != 0) {
                words += ONES[n / 100 % 10] + " hundred ";
            }
            return words + (n % 100 != 0 ? " and " + getNumberWords(n % 100) : "");
        }
    }

    static String getNumberWords(int n) {
        if (n < 10) // less than
            return ONES[n];
        else if (n < 20) // Teens
            return TEENS[n - 10];
        else
            return TENS[n / 10 - 2] + " " + (n % 10 != 0 ? ONES[n % 10] : ""); // all above 20 tens
    }
}
