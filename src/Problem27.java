public class Problem27 {
    // QUADRATIC PRIMES
    // quadratic formula: n² + n + 41 is a prime can generate prime consecutive from 0 to 39
    // quadratic formula: n² [−] 79n + 1601 is a prime can generate prime consecutive from 0 to 79
    // n² + an + b, where |a| [<] 1000 and |b| [<] 1000
    // Find the product of the coefficients, a and b, for the quadratic expression that produces
    // the maximum number of primes for consecutive values of n, starting with n = 0.


    public  static void main(String[] args) {
        System.out.println(productCoefficientsInQuadraticPrimeExp(30));
        System.out.println(productCoefficientsInQuadraticPrimeExp(41));
        System.out.println(productCoefficientsInQuadraticPrimeExp(500));
        System.out.println(productCoefficientsInQuadraticPrimeExp(100));
        System.out.println(productCoefficientsInQuadraticPrimeExp(1000));
        System.out.println(productCoefficientsInQuadraticPrimeExp(2000));

    }
    static int productCoefficientsInQuadraticPrimeExp(int maxCoeffient) {
        int coefficientA = 0, coefficientB = 0, maxPrimesCount = 0;
        for (int a = -maxCoeffient; a <= maxCoeffient; a++) {
            for (int b = -maxCoeffient; b <= maxCoeffient; b++) {
                int primesCount = numConsectivePrimes(a, b);
                if (primesCount > maxPrimesCount) {
                    maxPrimesCount = primesCount;
                    coefficientA = a;
                    coefficientB = b;
                }
            }
        }
        System.out.println("CoefficientA is " + coefficientA + " and CoefficientB is " + coefficientB + " and count is " + maxPrimesCount);
        return coefficientA * coefficientB;
    }

    static int numConsectivePrimes(int a, int b) {
        for (int i = 0; ; i++) {
            int n = i * i + a * i + b;
            if (n < 0 || Utility.isPrime(n) == 0)
                return i;
        }
    }
}
