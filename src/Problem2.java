public class Problem2 {
    //Each new term in the Fibonacci sequence is generated by adding the previous two terms.
    //By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    //By considering the terms in the Fibonacci sequence whose values do not exceed four million,
    //find the sum of the even-valued terms

    // input 2 and out put is 0
    // input 10 and out put is 10 (1,2,3,5,8) -> sum of (2,8)
    // input 100 and out put is 44 (1,2,3,5,8,13,21,34,55,89) -> sum of (2,8,34)

    //Even Fibonacci Numbers
    public static void main(String[] args) {
        System.out.println(sumOfEvenFibonacciWithDp(2));
        System.out.println(sumOfEvenFibonacciWithDp(10));
        System.out.println(sumOfEvenFibonacciWithDp(100));
        System.out.println(sumOfEvenFibonacci(2));
        System.out.println(sumOfEvenFibonacci(10));
        System.out.println(sumOfEvenFibonacci(100));
    }

    static int sumOfEvenFibonacciWithDp(int fibNumber) {
        int[] fib = new int[fibNumber + 2];
        fib[0] = 0;
        fib[1] = 1;
        int result = 0;
        for (int i = 2; i < fibNumber && fib[i - 1] < fibNumber; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            if (fib[i] % 2 == 0 && fib[i] < fibNumber)
                result += fib[i];
        }
        return result;
    }

    static int sumOfEvenFibonacci(int fibNumber) {
        int a = 1, b = 2, c = 3;
        int result = 0;
        if (fibNumber <= 2)
            return result;
        result = 2;
        while (c < fibNumber) {
            if (c % 2 == 0)
                result += c;
            a = b;
            b = c;
            c = a + b;
        }
        return result;
    }
}
