class Solution {
    public int change(int amount, int[] coins) {

        int[] cache = new int[amount + 1];
        cache[0] = 1;

        for (int coinIdx = 0; coinIdx < coins.length; coinIdx++) {
            int coin = coins[coinIdx];
            for (int a = coin; a <= amount; a++) {
                cache[a] += cache[a - coin];
            }
        }

        return cache[amount];
    }
}
