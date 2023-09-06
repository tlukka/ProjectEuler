public class Problem40 {
    // An irrational decimal fraction is created by concatenating the positive integers:
    //0.123456789101112131415161718192021...
    //It can be seen that the 12th digit of the fractional part is 1.
    //If dn represents the nth digit of the fractional part, find the value of the following expression.
    //d1 [×] d10 [×] d100 [×] d1000 [×] d10000 [×] d100000 [×] d1000000

    public static void main(String[] args) {
        System.out.println(productOfFractionDigits());
    }

    static int productOfFractionDigits() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 1000000; i++) {
            sb.append(i);
        }
        int prod = 1;
        for (int i = 1; i <= 6; i++) {
            prod *= sb.charAt((int) Math.pow(10, i) - 1) - '0';
        }
        return prod;
    }
}
