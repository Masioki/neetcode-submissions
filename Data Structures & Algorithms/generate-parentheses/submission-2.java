class Solution {
    public List<String> generateParenthesis(int n) {
        // List<String>[][] cache = new List[n+1][2*n+1];
        // cache[n][2*n] = new ArrayList<>();

        List<String> result = new ArrayList<>();
        step(n, 0, new StringBuilder(), result);
        return result;
    }

    private void step(int n, int open, StringBuilder current, List<String> result){
        if(current.length() == 2*n){
            result.add(current.toString());
        }

        if(open < n){
            current.append('(');
            step(n, open + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        int leftOpened = open * 2 - current.length();
        if(leftOpened > 0){
            current.append(')');
            step(n, open, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
