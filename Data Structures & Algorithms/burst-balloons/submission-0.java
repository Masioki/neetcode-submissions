class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0]=1;
        newNums[newNums.length-1]=1;
        nums = newNums;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = nums.length-3; i>=0; i--){
            for(int j = i + 2; j < nums.length; j++){
                for(int k = i+1; k < j; k++){
                   dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j]);
                }
            }
        }

        return dp[0][nums.length-1];
    }
}