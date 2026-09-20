class Solution {
  public int coinChange(int[] coins, int amount) {
    if(amount <= 0){
      return 0;
    }
    Arrays.sort(coins);
    int[] cache = new int[amount+1];
    Arrays.fill(cache, -1);
    for(int c = coins.length - 1; c >= 0; c--){
      int coin = coins[c];
      if(coin < cache.length ){
        cache[coin] = 1;
      }
    }
    int result = minCoinForAmount(coins, amount, cache);
    if(result == Integer.MAX_VALUE){
      return -1;
    }
    return result;
  }

  private int minCoinForAmount(int[] coins, int amount, int[] cache) {
    if(cache[amount] >= 0){
      return cache[amount];
    }

    int result = Integer.MAX_VALUE;
    for(int c = coins.length - 1; c >= 0; c--){
      int coin = coins[c];
      if(coin <= amount){
        int temp = minCoinForAmount(coins, amount -  coin, cache);
        if (temp != Integer.MAX_VALUE){
          result = Math.min(temp + 1, result);
        }
      }
    }
    cache[amount] = result;
    return result;
  }


}
