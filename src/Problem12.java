public class Problem12 {
    // Let us list the factors of the first seven triangle numbers:
    //1: 1
    //3: 1,3
    //6: 1,2,3,6
    //10: 1,2,5,10
    //15: 1,3,5,15
    //21: 1,3,7,21
    //28: 1,2,4,7,14,28
    //We can see that 28 is the first triangle number to have over five divisors.
    // What is the value of the first triangle number to have over five hundred divisors?


    public static void main(String[] args) {
        System.out.println(triangleDivisors(3));
        System.out.println(triangleDivisors(6));
        System.out.println(triangleDivisors(500));
    }

    static long triangleDivisors(int divisorCount) {
        int i = 1;
        long n = 1;
        while (true) {
            n = i * (i + 1) / 2;
            int count = Utility.divisorCount(n);
            if (count > divisorCount)
                break;
            i++;
        }
        return n;
    }
}
