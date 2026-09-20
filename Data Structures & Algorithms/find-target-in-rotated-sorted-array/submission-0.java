class Solution {
  public int search(int[] nums, int target) {
    int biggestIdx = bsBiggestIndex(nums);
    if (target >= nums[0]) {
      return bsValue(nums, 0, biggestIdx, target);
    } else {
      return bsValue(nums, biggestIdx + 1, nums.length - 1, target);
    }
  }

  private int bsBiggestIndex(int[] nums){
    if(nums.length == 1 || nums[0] < nums[nums.length - 1]){
      return nums.length - 1;
    }

    int start = 0;
    int end = nums.length - 1;
    while(start < end){
      int mid = (int) (start + Math.ceil((double) (end - start) / 2));
      if(nums[mid] > nums[start]){
        start = mid;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  private int bsValue(int[] nums, int start, int end, int target){
    while(start < end){
      int mid = start + ((end - start) / 2);
      if(nums[mid] < target) {
        start = start + 1;
      } else {
        end = mid;
      }
    }

    if(start >= nums.length || nums[end] != target){
      return -1;
    }
    return start;
  }
}
