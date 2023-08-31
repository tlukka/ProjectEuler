public class Problem20 {
    // Find the sum of the digits in the number 100!.

    //For example, 10! = 10 [×] 9 [×] ... [×] 3 [×] 2 [×] 1 = 3628800,
    // sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27
    public static void main(String[] args) {
        System.out.println(sumOfDigitsFactorial(10));
        System.out.println(sumOfDigitsFactorial(100));
    }

    static int sumOfDigitsFactorial(int n) {
        String fact = Utility.factorial(n).toString();
        int sum = 0;
        for (int i = 0; i < fact.length(); i++) {
            sum += fact.charAt(i) - '0';
        }
        return sum;
    }
}
