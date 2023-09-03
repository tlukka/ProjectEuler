public class Problem24 {
    //English-Lexicographic_Premutations
    // Find the millionth (1-based) permutation of (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    //A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the
    // digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
    // we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are: 012 021 102 120 201 210
    //What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

    public static void main(String[] args) {
        System.out.println(millonthPermutation(10, 999999));
        System.out.println(millonthPermutation(3, 4));
        System.out.println(millonthPermutation(4, 5));
    }

    static String millonthPermutation(int eleLen, int maxNumber) {
        // initialize
        int[] arr = new int[eleLen];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        // Permutation
        for (int i = 0; i < maxNumber; i++) {
            if (!Utility.nextPermutation(arr))
                throw new AssertionError();
        }
        // Return result
        String result = "";

        for (int i = 0; i < arr.length; i++)
            result += arr[i];

        return result;
    }

}
