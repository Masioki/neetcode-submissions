class Solution {
 public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int currentMax = nums[nums.length - 1];
        int currentMin = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        for(int i=nums.length-2; i>=0; i--){
            int tempCurrentMax = Math.max(nums[i], Math.max(currentMax*nums[i], currentMin*nums[i]));
            currentMin = Math.min(nums[i], Math.min(currentMax*nums[i], currentMin*nums[i]));
            currentMax = tempCurrentMax;
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
