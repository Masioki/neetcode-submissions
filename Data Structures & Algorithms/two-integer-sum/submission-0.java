class Solution {
   public int[] twoSum(int[] nums, int target) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        int complementIndex = map.get(complement).iterator().next();
        if (i > complementIndex) {
          return new int[] {complementIndex, i};
        } else {
          return new int[] {i, complementIndex};
        }
      }
      map.putIfAbsent(nums[i], new HashSet<>());
      map.get(nums[i]).add(i);
    }
    return new int[] {-1, -1};
  }
}
