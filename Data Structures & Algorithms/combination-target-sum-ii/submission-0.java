class Solution {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    step(target, candidates, 0, 0, new ArrayList<>(), result);
    return result;
  }

  private void step(int target, int[] candidates, int index, int total, List<Integer> current,
                    List<List<Integer>> result) {
    if (total == target) {
      result.add(new ArrayList<>(current));
    }
    if (index >= candidates.length) {
      return;
    }

    int i = index;
    while (i < candidates.length) {
      if (target < total + candidates[i]) {
        return;
      }
      int count = 1;
      while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
        i++;
        count++;
      }
      for (int c = 1; c <= count; c++) {
        current.add(candidates[i]);
        step(target, candidates, i + 1, total + c * candidates[i], current, result);
      }
      for (int c = 1; c <= count; c++) {
        current.removeLast();
      }
      i++;
    }
  }
}
