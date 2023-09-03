import java.math.BigInteger;

public class Problem25 {
    // 12th Fibonaacci is 144 and it is the first term to contain three digits.
    // What is the first term in the Fibonacci sequence to contain 1000 digits?

    public static void main(String[] args) {
        //System.out.println(Utility.nextFibonacci(5));
        System.out.println(getNthDigitsFibonacci(3));
        System.out.println(get1000thDigitsFib(1000));
        System.out.println(get1000thDigitsFib(3));
        System.out.println(get1000thDigitsFib(100));
    }

    // Below logic good with very small fibonacci numbers
    static int getNthDigitsFibonacci(int nthDigits) {
        int n = 1;

        while (true) {
            long nextFibonacci = Utility.nextFibonacci(n);
            int digits = Long.toString(nextFibonacci).length();
            if (nthDigits == digits) {
                System.out.println(nextFibonacci);
                break;
            }
            n++;
        }
        return n + 1;
    }


    static int get1000thDigitsFib(int digits) {
        BigInteger lowerLimit = BigInteger.TEN.pow(digits - 1);
        BigInteger upperLimit = BigInteger.TEN.pow(digits);
        BigInteger current = BigInteger.ZERO;
        BigInteger prev = BigInteger.ONE;
        for (int i = 0; ; i++) {
            if (current.compareTo(upperLimit) >= 0)
                throw new RuntimeException("Not found");
            else if (current.compareTo(lowerLimit) >= 0) {
                System.out.println(current);
                System.out.println(current.toString().length());
                return i;
            }
            // Advance the Fibonacci sequence by one step
            BigInteger temp = current.add(prev);
            prev = current;
            current = temp;

        }
    }


}
