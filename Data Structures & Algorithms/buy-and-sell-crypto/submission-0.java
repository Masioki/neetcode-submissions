class Solution {
public int maxProfit(int[] prices) {
  if(prices.length < 2) return 0;

  int i = 1;
  int currentMin = prices[0];
  int maxAmpl = 0;
  while (i < prices.length) {
    if(prices[i] < currentMin) {
      currentMin = prices[i];
    }
    maxAmpl = Math.max(maxAmpl, prices[i] - currentMin);
    i++;
  }

  return maxAmpl;
}
}
