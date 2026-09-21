class Solution {
  public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            nums[i] = Math.max(nums[i], nums[i+1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
