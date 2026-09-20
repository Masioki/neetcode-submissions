class Solution {
    public int missingNumber(int[] nums) {
        long n = nums.length ;
        long sum = (n * (n + 1)) / 2;
        for(int num : nums){
            sum -= num;
        }
        return (int)sum;
    }
}
