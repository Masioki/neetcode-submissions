class Solution {
    public int climbStairs(int n) {
        // 1 - 1
        // 2 - 2
        // 3 - 3
        // 4 - 5
        // 5 -
        if (n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] cache = new int[]{1, 2};
        for(int i = 3; i <= n; i++){
            int last = cache[1];
            cache[1] = last + cache[0];
            cache[0] = last;
        }
        return cache[1];
    }
}
