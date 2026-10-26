class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.isEmpty() || text2.isEmpty()) return 0;

        // dp[i1][i2]:
        //  max(1 + dp[i1+1][i2+1] (if match), dp[i1+1][i2], dp[i1][i2+1])

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i1 = text1.length() -1; i1 >= 0; i1-- ){
            for(int i2 = text2.length() -1; i2 >= 0; i2-- ){
                // match
                if(text1.charAt(i1) == text2.charAt(i2)) {
                    dp[i1][i2] = 1 + dp[i1+1][i2+1];
                }
                dp[i1][i2] = Math.max(dp[i1][i2], Math.max(dp[i1+1][i2], dp[i1][i2+1]));
            }
        }
        return dp[0][0];
    }
}
