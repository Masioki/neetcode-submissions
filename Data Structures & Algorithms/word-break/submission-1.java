class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] cache = new int[s.length()];
        return canBreak(s, 0, wordDict, cache);
    }

    private boolean canBreak(String word, int start, List<String> wordDict, int[] cache){
        if(start >= word.length()){
            return true;
        }
        if(cache[start] > 0){
            return cache[start] == 1;
        }
        for(int len : fittingLenghts(word, start, wordDict)){
            if(canBreak(word, start + len, wordDict, cache)){
                cache[start] = 1;
                return true;
            }
        }
        cache[start] = 2;
        return false;
    }

    private Set<Integer> fittingLenghts(String word, int start, List<String> wordDict){
        Set<Integer> result = new HashSet<>();
        for(String w : wordDict){
            if(word.startsWith(w, start)){
                result.add(w.length());
            }
        }
        return result;
    }

}
