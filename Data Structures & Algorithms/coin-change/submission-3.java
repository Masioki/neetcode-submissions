class Solution {
  public int coinChange(int[] coins, int amount) {

    int[] cache = new int[amount+1];
    Arrays.fill(cache, amount+1);
    cache[0] = 0;

    for(int a = 1; a <= amount; a++){
      for(int coin : coins){
        if(coin <= a){
          cache[a] = Math.min(cache[a], 1 + cache[a-coin]);
        }
      }
    }
    return cache[amount] <= amount ? cache[amount] : -1;
  }
}
