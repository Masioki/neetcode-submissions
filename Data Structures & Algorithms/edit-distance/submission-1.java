class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        if (word1.isEmpty())
            return word2.length();
        if (word2.isEmpty())
            return word1.length();

        // dp[i][j]: min
        //  - equal -> 0 + dp[i+1][j+1]
        //  - replace -> 1 + dp[i+1][j+1]
        //  - skip/remove -> 1 + dp[i+1][j]
        //  - insert    -> 1 + dp[i][j+1]
        // + len diff at the end insert/remove

        int dp[][] = new int[word1.length()][word2.length()];

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                int value = c1 == c2 ? 0 : 1;
                if (i == word1.length() - 1 || j == word2.length() - 1) {
                    value += Math.abs((word1.length() - 1 - i) - (word2.length() - 1 - j));
                } else {
                    value += dp[i + 1][j + 1];
                }

                if (i < word1.length() - 1) {
                    value = Math.min(value, 1 + dp[i + 1][j]);
                }
                if (j < word2.length() - 1) {
                    value = Math.min(value, 1 + dp[i][j+1]);
                }
                dp[i][j] = value;
            }
        }

        return dp[0][0];
    }
}
