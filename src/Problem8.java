public class Problem8 {
    // Largest Product and Sum of K Consecutive digits in N digits
    // 3675356291 and k =5 -> largest product is 3150 (36753, 67535, 75356, 53562, 35629, 56291) -> largest 6*7*5*3*5)
    // 2709360626 and k=5 -> 0. 0 lies in section of 5 consecutive digits and hence product is 0.

    public static void main(String[] args) {
        System.out.println(maxProductAndSumOfKDigits("3675356291", 5));
        System.out.println(maxProductAndSumOfKDigits("2709360626", 5));
        System.out.println(maxProductAndSumOfKDigits("3605356297", 3));
        maxProductSumEfficient("3675356291", 5);
        maxProductSumEfficient("2709360626", 5);
        maxProductSumEfficient("3605356297", 3);
        maxProductSumEfficient("3601990545", 3);
    }

    static void maxProductSumEfficient(String num, int k) {
        // Sliding window technique
        int length = num.length();
        int product = 1, sum = 0, zeroesInWindow = 0;
        for (int i = 0; i < k; i++) {
            int currentDigit = num.charAt(i) - '0';
            sum += currentDigit;
            if (currentDigit != 0)
                product *= currentDigit;
            else
                zeroesInWindow++;
        }

        // Update maxProd and maxSum
        int maxProd = 0;
        if (zeroesInWindow == 0)
            maxProd = product;
        int maxSum = sum;

        // Start traversing the next element
        for (int i = k; i < length; i++) {

            // Multiply with the current digit and divide by the first digit of previous window
            int currentDigit = num.charAt(i) - '0';
            int firstDigitOldWindow = num.charAt(i - k) - '0';
            if (currentDigit != 0 && firstDigitOldWindow != 0) {
                product = product * currentDigit / firstDigitOldWindow;
            } else if (currentDigit != 0 && firstDigitOldWindow == 0) {
                zeroesInWindow--;
                product *= currentDigit;

            } else if (currentDigit == 0 && firstDigitOldWindow != 0) {
                zeroesInWindow++;
                product /= firstDigitOldWindow;
            }

            if (zeroesInWindow == 0)
                maxProd = Math.max(maxProd, product);

            sum += currentDigit - firstDigitOldWindow;
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("Maximum Product = " + maxProd);
        System.out.println("Maximum Sum = " + maxSum);

    }

    static long maxProductAndSumOfKDigits(String num, int k) {
        long startTime = System.currentTimeMillis();
        if (k < 0) return 0;
        int lengthDigits = num.length();
        long max_Product = Long.MIN_VALUE;
        long max_Sum = Long.MIN_VALUE;
        for (int i = 0; i <= lengthDigits - k; i++) {
            int product = 1;
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                product *= num.charAt(j) - '0';
                sum += num.charAt(j) - '0';
            }
            max_Product = Math.max(product, max_Product);
            max_Sum = Math.max(sum, max_Sum);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken is " + (endTime - startTime) + " Max Sum is " + max_Sum);
        return max_Product;
    }
}
