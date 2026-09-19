class Solution {
      public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(2 ^ nums.length);
        result.add(List.of());
        for(int i=0; i< nums.length; i++){
            List<List<Integer>> toAdd = new ArrayList<>(2^i);
            for(var l : result){
                List<Integer> newList = new ArrayList<>(l.size() + 1);
                newList.addAll(l);
                newList.add(nums[i]);
                toAdd.add(newList);
            }
            result.addAll(toAdd);
        }
        return result;
    }
}
