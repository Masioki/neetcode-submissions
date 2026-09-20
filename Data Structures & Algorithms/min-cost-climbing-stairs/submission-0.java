class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[]{
            cost[cost.length-1],
            cost[cost.length-2]
        };
        for(int i = cost.length-3; i >= 0; i--){
            int newCost = Math.min(cache[0], cache[1]) + cost[i];
            cache[0] = cache[1];
            cache[1] = newCost;
        }

        return Math.min(cache[0], cache[1]);
    }
}
