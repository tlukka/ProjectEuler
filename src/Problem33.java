public class Problem33 {
    // Digits Cancelling Fractions
    // The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify
    // it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
    //
    //We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
    //
    //There are exactly four non-trivial examples of this type of fraction, less than one in value, and
    // containing two digits in the numerator and denominator.
    //If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

    public static void main(String[] args) {
        System.out.println(productDigitsCancellingFractions());
    }

    static int productDigitsCancellingFractions() {
        //  Consider an arbitrary fraction n/d:
        // Let n = 10 * n1 + n0 be the numerator.
        // Let d = 10 * d1 + d0 be the denominator.
        //  simplification with n0 = d0 is impossible because
        // n1 / d1 = n / d = (10*n1 + n0) / (10*d1 + n0).
        // n1 * (10*d1 + n0) = d1 * (10*n1 + n0).
        //  n1 = d1.
        // we only need to consider the cases where n0 = d1 or n1 = d0.
        // check that n1/d0 = n/d; in the second case, check that n0/d1 = n/d.
        int numerator = 1;
        int denominator = 1;
        for (int d = 10; d < 100; d++) {
            for (int n = 10; n < d; n++) {
                int n0 = n % 10, n1 = n / 10;
                int d0 = d % 10, d1 = d / 10;
                if (n1 == d0 && n0 * d == d1 * n || n0 == d1 && n1 * d == n * d0) {
                    numerator *= n;
                    denominator *= d;
                }
            }
        }

        return (denominator / Utility.gcd(numerator, denominator));
    }
}
