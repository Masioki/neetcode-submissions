class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1) return false;

        sum = sum / 2;

        Set<Integer> sums = new HashSet<>();
        sums.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            Set<Integer> newSums = new HashSet<>();
            for(int s : sums){
                if(s + num <= sum){
                    newSums.add(s+num);
                }
                if(s - num >= -sum){
                    newSums.add(s - num);
                }
            }
            sums = newSums;
        }
        return sums.contains(0);
    }
}
