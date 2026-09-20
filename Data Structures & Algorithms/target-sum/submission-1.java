class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        List<Map<Integer, Integer>> cache = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            cache.add(new HashMap<>());
        }
        // int[][] cache = new int[nums.length][target];
        // for(int[] entry : cache){
        //     Arrays.fill(entry, -1);
        // }
        // Arrays.fill(cache[cache.length - 1], 0);
        // cache[cache.length - 1][nums[nums.length-1]] = 1
        return dp(nums, 0, target, cache);
    }

    private int dp(int[] nums, int index, int target, List<Map<Integer, Integer>> cache){
        if(index >= nums.length){
            return 0;
        }
        if(index == nums.length - 1){
            if(target == nums[index] && target == 0){
                return 2;
            }
            if(target == nums[index] || target == -nums[index]){
                return 1;
            }
            return 0;
        }
        if(cache.get(index).containsKey(target)){
            return cache.get(index).get(target);
        }

        int result = dp(nums, index + 1, target + nums[index], cache) + dp(nums, index + 1, target - nums[index], cache);
        cache.get(index).put(target, result);
        return result;
    }
}
