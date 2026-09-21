class Solution {
     public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] maxSubArrayFrom = new int[nums.length];
        maxSubArrayFrom[nums.length - 1] = nums[nums.length - 1];
        int max = maxSubArrayFrom[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            maxSubArrayFrom[i] = Math.max(nums[i], maxSubArrayFrom[i+1] + nums[i]);
            max = Math.max(max, maxSubArrayFrom[i]);
        }
        return max;
    }
}
