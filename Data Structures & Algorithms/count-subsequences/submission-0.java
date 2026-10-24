class Solution {
    // babg bag
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()){
            return 0;
        }

        int[][] cache = new int[s.length()][t.length()];
        for(int[] entry : cache){
            Arrays.fill(entry, -1);
        }
        return distinctFrom(s, 0, t, 0, cache);
    }

    private int distinctFrom(String s, int sIdx, String t, int tIdx, int[][] cache){
        if(sIdx >= s.length() || tIdx >= t.length()){
            return 0;
        }
        if(t.length() - tIdx > s.length() - sIdx){
            return 0;
        }
        if(cache[sIdx][tIdx] >= 0){
            return cache[sIdx][tIdx];
        }

        int result = 0;
        if(s.charAt(sIdx) == t.charAt(tIdx)){
            if(tIdx == t.length() - 1){
                result++;
            } else {
                result += distinctFrom(s, sIdx + 1, t, tIdx + 1, cache);
            }
        }
        result += distinctFrom(s, sIdx + 1, t, tIdx, cache);
   
        cache[sIdx][tIdx] = result;
        return result;
    }
}