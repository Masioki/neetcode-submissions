class Solution {
   public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>();
        while(!history.contains(n) && n != 1){
            history.add(n);
            n = convert(n);
        }
        return n == 1;
    }

    private int convert(int n){
        char[] chars = Integer.toString(n).toCharArray();
        int result = 0;
        for(char c : chars){
            result += Math.pow(c - '0', 2);
        }
        return result;
    }
}
