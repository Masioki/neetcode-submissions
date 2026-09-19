class Solution {
   public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    return countMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
  }
}
