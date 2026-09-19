class Solution {
  public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        step(nums, new boolean[nums.length], results, new ArrayList<>());
        return results;
    }

    private void step(int[] nums, boolean[] choices, List<List<Integer>> results, List<Integer> current){
        if(current.size() == nums.length){
            results.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i< nums.length; i++){
            if(choices[i]){
                continue;
            }
            choices[i] = true;
            current.add(nums[i]);
            step(nums, choices, results, current);
            choices[i] = false;
            current.removeLast();
        }
    }
}
