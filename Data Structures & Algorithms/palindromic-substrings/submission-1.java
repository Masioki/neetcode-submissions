class Solution {
    public int countSubstrings(String s) {
        int[] cache = new int[s.length()];
        cache[s.length() - 1] = 1;
        int[][] palindromCache = new int[s.length()][s.length()];
        for(int i = 0; i < palindromCache.length; i++){
            palindromCache[i][i] = 1;
        }
        
        for(int i = s.length() - 2; i >= 0; i--){
            cache[i] = cache[i+1] + countPalidromesFrom(s, i, palindromCache);
        }
        return cache[0];
    }

    private int countPalidromesFrom(String s, int index, int[][] palindromCache){
        int result = 1;
        for(int i=index+1; i < s.length(); i++){
            if(isPalindrome(s, index, i, palindromCache)){
                result++;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int from, int to, int[][] palindromCache){
        if(to < from){
            return true;
        }
        if(palindromCache[from][to] > 0){
            return palindromCache[from][to] == 1;
        }
        boolean result = s.charAt(from) == s.charAt(to) && isPalindrome(s, from+1, to-1, palindromCache);
        palindromCache[from][to] = result ? 1 : 2;
        return result;
    }
}
