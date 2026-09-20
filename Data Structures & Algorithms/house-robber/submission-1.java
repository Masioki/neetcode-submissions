class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        cache[cache.length-1] = nums[nums.length-1];
        cache[cache.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);
        for(int i=nums.length-3; i >= 0; i--){
            cache[i] = Math.max(nums[i] + cache[i + 2], cache[i + 1]);
        }
        return cache[0];
    }
}
