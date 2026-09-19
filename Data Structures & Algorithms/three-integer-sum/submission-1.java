class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return Collections.emptyList();
    }
    Arrays.sort(nums); // n log n
    Set<List<Integer>> res = new HashSet<>();
    for (int midIdx = 1; midIdx < nums.length - 1; midIdx++) {
      int startIdx = 0;
      int endIdx = nums.length - 1;
      while (startIdx < midIdx && midIdx < endIdx) {
        int sum = nums[startIdx] + nums[midIdx] + nums[endIdx];
        if (sum == 0) {
          res.add(Arrays.asList(nums[startIdx], nums[midIdx], nums[endIdx]));
          startIdx++;
          endIdx--;
        } else if (sum < 0) {
          startIdx++;
        } else {
          endIdx--;
        }
      }
    }
    return new ArrayList<>(res);
  }
}
