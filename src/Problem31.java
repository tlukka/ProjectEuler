public class Problem31 {
    // COIN SUMS
    // In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
    //1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
    //It is possible to make £2 in the following way: 1[×]£1 + 1[×]50p + 2[×]20p + 1[×]5p + 1[×]2p + 3[×]1p
    //How many different ways can £2 be made using any number of coins?


    public static void main(String[] args) {
        System.out.println(countSumCoins(new int[]{1, 2, 5, 10, 20, 50, 100, 200}, 200));
        System.out.println(countSumCoins(new int[]{1, 2, 5, 10, 20}, 20));
        System.out.println(countSumCoins(new int[]{1, 2, 5, 10, 20}, 15));
        System.out.println(countSumCoins(new int[]{1, 2, 5, 10, 20}, 10));
        System.out.println(countSumCoins(new int[]{1, 2, 5, 10, 20}, 3));
    }

    static int countSumCoins(int[] coins, int targetSum) {
        // ways[i] is the number of ways to use any copies of the first i coin values to form an unordered sum of j

        int[] targets = new int[targetSum + 1];
        targets[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < targets.length; i++) {
                if (i >= coin)
                    targets[i] += targets[i - coin]; // sum up with pervious
            }
        }
        return targets[targetSum];
    }
}
