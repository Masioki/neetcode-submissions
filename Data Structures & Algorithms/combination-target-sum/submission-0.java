class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    step(candidates, target, 0, 0, new ArrayList<>(), result);
    return result;
  }

  private void step(int[] candidates, int target, int index, int total, List<Integer> current, List<List<Integer>> result){
    if(total == target) {
        result.add(new ArrayList<>(current));
    }

    for(int i = index; i < candidates.length; i++){
        if(total + candidates[i] > target){
            return;
        }
        current.add(candidates[i]);
        step(candidates, target, i, total + candidates[i], current, result);
        current.remove(current.size() - 1);
    }
  }
}
