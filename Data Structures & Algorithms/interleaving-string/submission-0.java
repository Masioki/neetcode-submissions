class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        if (s1.isEmpty())
            return s2.equals(s3);
        if (s2.isEmpty())
            return s1.equals(s3);

        // dp[s1Idx][s2Idx]:
        //   match && dp[s1Idx+1][s2Idx]
        //   match && dp[s1Idx][s2Idx+1])
        // result = dp[0][0]

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int s1Idx = s1.length(); s1Idx >= 0; s1Idx--) {
            for (int s2Idx = s2.length(); s2Idx >= 0; s2Idx--) {
                int s3Idx = s1Idx + s2Idx;
                // order 0
                boolean match = false;
                if (s1Idx < s1.length()) {
                    match = s1.charAt(s1Idx) == s3.charAt(s3Idx);
                    dp[s1Idx][s2Idx] = match && dp[s1Idx + 1][s2Idx];
                }
                // order 1
                if (s2Idx < s2.length()) {
                    match = s2.charAt(s2Idx) == s3.charAt(s3Idx);
                    dp[s1Idx][s2Idx] = dp[s1Idx][s2Idx] || (match && dp[s1Idx][s2Idx + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
