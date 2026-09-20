class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] counts = new int[21];
        for(int num : nums){
            counts[num + 10]++;
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < counts.length; i++){
            int count = counts[i];
            int num = i - 10;
            if(count > 0){
                result = powerSetWith(result, num, count);
            }
        }
        return result;
    }

    private List<List<Integer>> powerSetWith(List<List<Integer>> current, int num, int count) {
        List<List<Integer>> result = new ArrayList<>(current); // size ?   
        for(var list : current){
            for(int i=0; i < count; i++){
                list = new ArrayList<>(list);
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
