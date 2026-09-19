class Solution {
    private record Key(int open, int close){

    }

    public List<String> generateParenthesis(int n) {
        Map<Key, List<String>> cache = new HashMap<>();
        for(int i=0; i < n; i++) {
            cache.put(new Key(n, i), List.of(")".repeat(n-i)));
        }

        return step(0, 0, cache);
    }

    private List<String> step(int open, int closed, Map<Key, List<String>> cache){
        // ((())..., (()()..., ()()(...
        var cachedValue = cache.get(new Key(open, closed));
        if (cachedValue != null){
            return cachedValue;
        }

        // we know that we can open
        List<String> results = new ArrayList<>();
        List<String> nextStepResults = step(open+1, closed, cache);
        for(var s : nextStepResults){
            results.add("(" + s);
        }

        // we can close if no. of closed is less than open
        if(closed < open){
            nextStepResults = step(open, closed+1, cache);
            for(var s : nextStepResults){
                results.add(")" + s);
            }
        }
        cache.put(new Key(open, closed), results);
        return results;
    }
}
