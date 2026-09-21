class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return true;
        }
        int[] cache = new int[nums.length];
        cache[cache.length - 1] = 1;

        return canJumpFrom(nums, 0, cache);
    }

    private boolean canJumpFrom(int[] nums, int index, int[] cache){
        if(index >= nums.length){
            return false;
        }
        if(cache[index] > 0){
            return cache[index] == 1;
        }
        
        int maxJumps = nums[index];
        boolean result = false;
        for(int i = 1; i<= maxJumps; i++){
            if(canJumpFrom(nums, index + i, cache)){
                result = true;
                break;
            }
        }
        cache[index] = result ? 1 : 2;
        return result;
    }
}
