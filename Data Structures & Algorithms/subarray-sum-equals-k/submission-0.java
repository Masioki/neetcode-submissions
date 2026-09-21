class Solution {
 public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int result = 0;
        int runningSum = 0;
        for(int num : nums){
            runningSum += num;
             if(sums.containsKey(runningSum - k)){
                result += sums.get(runningSum - k);
            }
            if(!sums.containsKey(runningSum)){
                sums.put(runningSum, 0);
            }
            sums.put(runningSum, sums.get(runningSum) + 1);
        }
        return result;
    }
}