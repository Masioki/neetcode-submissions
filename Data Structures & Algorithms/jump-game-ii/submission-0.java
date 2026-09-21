class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }

        int left = 0;    
        int right = nums[0];
        int steps = 1;
        while(right < nums.length - 1){
            int nextRight = findMaxIndex(nums, left, right);
            left = right;
            right = nextRight;
            steps++;
        }
        return steps;
    }

    private int findMaxIndex(int[] nums, int left, int right){
        int max = 0;
        for(int i = left; i <= right; i++){
            max = Math.max(max, nums[i] + i);
        }
        return max;
    }
}
