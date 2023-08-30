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
        System.out.println(numToEnglishWords(13));
        System.out.println(numToEnglishWords(83));
        System.out.println(numToEnglishWords(70));
        System.out.println(numToEnglishWords(342));
        System.out.println(numToEnglishWords(115));
        System.out.println(numToEnglishWords(342).length());
        System.out.println(numToEnglishWords(115).length());
        System.out.println(numToEnglishWords(1000));
        System.out.println(numLetterCount(342));
        System.out.println(numLetterCount(115));
        System.out.println(numLetterCount(1000));


        System.out.println(toEnglish(13));
        System.out.println(toEnglish(83));
        System.out.println(toEnglish(70));
        System.out.println(toEnglish(342));
        System.out.println(toEnglish(115));
        System.out.println(toEnglish(1000));
        System.out.println(toEnglish(342).length());
        System.out.println(toEnglish(115).length());
        System.out.println(toEnglish(1000).length());

        System.out.println(toEnglish(23132).length());

        System.out.println(numLetterCountWithSimplified(342));
        System.out.println(numLetterCountWithSimplified(115));
        System.out.println(numLetterCountWithSimplified(1000));

    }

    static String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    static String[] LESS_THAN_20 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};

    static String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    static String toEnglish(int n) {
        if (n < 0 || n > 100000)
            throw new IllegalArgumentException("input is not in the valid range");
        if (0 <= n && n < 20)
            return LESS_THAN_20[n];
        else if (20 <= n && n < 100)
            return TENS[n / 10 - 2] + (n % 10 != 0 ? LESS_THAN_20[n % 10] : "");
        else if (100 <= n && n < 1000)
            return LESS_THAN_20[n / 100] + "hundred"  + (n % 100 != 0 ? "and" + toEnglish(n % 100) : "");
        else {
            return toEnglish(n / 1000) + "thousand" + (n % 1000 != 0 ? "and" + toEnglish(n % 1000) : "");
        }
    }

    static int numLetterCountWithSimplified(int n) {
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += toEnglish(i).length();
        }
        long endTime = System.nanoTime();
        System.out.println("Time Taken with Simplified is " + (endTime - startTime) / 100000 + "ms");
        return sum;
    }

    static int numLetterCount(int n) {
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numToEnglishWords(i).length();
        }
        long endTime = System.nanoTime();
        System.out.println("Time Taken is " + (endTime - startTime) / 100000 + "ms");
        return sum;
    }

    static String numToEnglishWords(int n) {
        if (n < 0 || n > 99999)
            throw new IllegalArgumentException("input is not in the valid range");
        if (n < 100) {
            return getNumberWords(n);
        } else {
            String words = "";
            if (n >= 1000) {
                words += getNumberWords(n / 1000) + "thousand";
            }
            if (n / 100 % 10 != 0) {
                words += ONES[n / 100 % 10] + "hundred";
            }
            return words + (n % 100 != 0 ? "and" + getNumberWords(n % 100) : "");
        }
    }

    static String getNumberWords(int n) {
        if (n < 10) // less than
            return ONES[n];
        else if (n < 20) // Teens
            return TEENS[n - 10];
        else
            return TENS[n / 10 - 2] + (n % 10 != 0 ? ONES[n % 10] : ""); // all above 20 tens
    }
}
