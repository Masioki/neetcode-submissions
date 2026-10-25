class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length <=1)return 0;
        // dp[day][true] = max(price[day] + dp[day+2][false], dp[day+1][true])
        // dp[day][false] = max(-price[day] + dp[day+1][true], dp[day+1][false])
        int[][] dp = new int[prices.length][2];

        for(int i = prices.length -1; i >= 0; i--){
            // has stock
            int sell = prices[i];
            if(i < dp.length -2){
                sell += dp[i+2][0];
            }
            if(i < dp.length -1){
                sell = Math.max(sell, dp[i+1][1]);
            }
            dp[i][1] = Math.max(sell, 0);

            // no stock
            int buy = -prices[i];
            if(i < dp.length - 1){
                buy = Math.max(buy + dp[i+1][1], dp[i+1][0]);
            }
            dp[i][0] = Math.max(buy, 0);
        }

        return dp[0][0];
    }
}
