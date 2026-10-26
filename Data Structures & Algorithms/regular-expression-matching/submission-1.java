class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;

        // empty strings ?
        // dp[sIdx][pIdx]
        //  char - match(sIdx, pIdx) && dp[sIdx+1][pIdx+1]
        //  .    - dp[sIdx+1][pIdx+1]
        //  char*    - (match(sIdx, pIdx) && dp[sIdx+1][pIdx]) || dp[sIdx][pIdx+2]
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[sLen][pLen] = true;

        for (int sIdx = sLen; sIdx >= 0; sIdx--) {
            for (int pIdx = pLen - 1; pIdx >= 0; pIdx--) {
                // Sprawdzamy, czy następny znak to '*'
                boolean hasStar = (pIdx + 1 < pLen && p.charAt(pIdx + 1) == '*');

                if (hasStar) {
                    // Opcja 1: Ignorujemy parę (znak + '*') -> zero wystąpień (przeskok o 2 we
                    // wzorcu)
                    dp[sIdx][pIdx] = dp[sIdx][pIdx + 2];

                    // Opcja 2: Jeśli obecny znak pasuje, zużywamy znak z 's' i zostajemy przy tym
                    // samym wzorcu
                    if (sIdx < sLen && match(s.charAt(sIdx), p.charAt(pIdx))) {
                        dp[sIdx][pIdx] = dp[sIdx][pIdx] || dp[sIdx + 1][pIdx];
                    }
                } else {
                    // Zwykły znak lub kropka '.'
                    if (sIdx < sLen && match(s.charAt(sIdx), p.charAt(pIdx))) {
                        dp[sIdx][pIdx] = dp[sIdx + 1][pIdx + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean match(char s, char p) {
        return p == '.' || s == p;
    }
}
