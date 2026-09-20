class Solution {
  public int rob(int[] nums) {
    // 3 1 2 5
    if(nums.length == 0){
      return 0;
    }
    if(nums.length == 1){
      return nums[0];
    }
    if(nums.length == 2){
      return Math.max(nums[0], nums[1]);
    }

    return Math.max(
        nums[0] + rob(nums, 2, nums.length - 2),
        rob(nums, 1, nums.length - 1)
    );
  }

  private int rob(int[] nums, int startIdx, int endIndx){
    if(startIdx > endIndx){
      return 0;
    }
    // edge
    int[] cache = new int[endIndx+1];
    cache[endIndx] = nums[endIndx];
    cache[endIndx - 1] = Math.max(nums[endIndx], nums[endIndx - 1]);
    for(int i = endIndx - 2; i>= startIdx; i--){
      cache[i] = Math.max(nums[i] + cache[i + 2], cache[i + 1]);
    }
    return cache[startIdx];
  }
}
