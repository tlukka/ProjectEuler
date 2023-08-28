import java.util.Arrays;

public class Problem9 {
    //Special Pythagorean Triplet
    // Given N, check if exists Pythagorean Triplet a+b+c = N and Find maximum possible value of abc.
    // N=12 -> 3+4+5 => product is 60
    // N=4  than there is no triplet so print -1;
    public static void main(String[] args) {
        System.out.println(getProductOfTripletInPythagorean(12));
        System.out.println(getProductOfTripletInPythagorean(4));
        pythagoreanTriplet(12);
        pythagoreanTriplet(4);

        int[] arr = {3, 1, 4, 6, 5};
        int[] arr1 = {3, 1, 4, 6, 5};
        System.out.println(checkTripletBF(arr));
        System.out.println(checkTripletSort(arr1));

        int[] arr3 = new int[]{10, 4, 6, 12, 5};
        int[] arr4 = new int[]{10, 4, 6, 12, 5};
        //System.out.println(checkTripletBF(arr3));
        System.out.println(checkTripletSort(arr4));
    }

    static long getProductOfTripletInPythagorean(int n) {
        int maxProduct = -1;
        for (int a = 1; a <= n / 3; a++) {
            int b = n * (a - n / 2) / (a - n);
            int c = n - a - b;
            if (a * a + b * b == c * c)
                maxProduct = Math.max(maxProduct, a * b * c);
        }
        return maxProduct;
    }

    static void pythagoreanTriplet(int n) {
        // Considering triplets in sorted order. The value of first element in sorted triplet can be at-most n/3.
        for (int i = 1; i <= n / 3; i++) {
            // The value of second element must be less than equal to n/2
            for (int j = i + 1; j <= n / 2; j++) {
                int k = n - i - j;
                if (i * i + j * j == k * k) {
                    System.out.print(i + ", " +
                            j + ", " + k);
                    System.out.println(" and Product of number is " + i * j * k);
                    return;
                }
            }
        }
        System.out.println("No Triplet");
    }

    // Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
    // that satisfies a2 + b2 = c2

    static boolean checkTripletBF(int[] arr) {
        //Brute force
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    long x = arr[i] * arr[i];
                    long y = arr[j] * arr[j];
                    long z = arr[k] * arr[k];
                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }
        return false;
    }

    static boolean checkTripletSort(int[] arr) {
        // Square of Elements
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] * arr[i];

        Arrays.sort(arr);

        //Brute force
        for (int i = arr.length - 1; i >= 2; i--) {
            int l = 0; //index of the first element
            int r = i - l; //index of the last element
            while (l < r) {
                if (arr[l] + arr[r] == arr[i])
                    return true;
                // move elements
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }

}
