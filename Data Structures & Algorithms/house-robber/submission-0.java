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
        return rob(nums, cache, 0);
    }

    private int rob(int[] nums, int[] cache, int index){
        if(index >= nums.length){
            return 0;
        }
        if(cache[index] >= 0){
            return cache[index];
        }

        int result = Math.max(nums[index] + rob(nums, cache, index + 2), rob(nums, cache, index + 1));
        cache[index] = result;
        return result;
    }
}
