import java.math.BigInteger;

public class Problem16 {
    //Power Digit Sum

    public static void main(String[] args) {
        System.out.println(powerDigitSum(15));
        System.out.println(powerDigitSum(1000));
    }

    static long powerDigitSum(int p) {
        long startTime = System.nanoTime();
        String powerString = BigInteger.ONE.shiftLeft(p).toString(); // 2 power p
        int sum = 0;
        for (int i = 0; i < powerString.length(); i++) {
            int digit = powerString.charAt(i) - '0';
            sum += digit;
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for process is " + (endTime-startTime)/1000000 + "ms");
        return sum;
    }

}
