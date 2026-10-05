class Solution {
    public int trap(int[] height) {

        int[] leftMax = prepareLeftMax(height);
        int[] rightMax = prepareRightMax(height);

        int result = 0;
        for(int i=1; i <height.length-1; i++){
            result += Math.max(Math.min(leftMax[i-1], rightMax[i+1]) - height[i], 0);
        }
        return result;
    }

    private int[] prepareLeftMax(int[] height) {
        int[] result = new int[height.length];
        result[0] = height[0];
        for(int i=1; i< result.length; i++){
            result[i] = Math.max(result[i-1], height[i]);
        }
        return result;
    }

    private int[] prepareRightMax(int[] height) {
        int[] result = new int[height.length];
        result[height.length - 1] = height[height.length - 1];
        for(int i=result.length - 2; i >= 0; i--){
            result[i] = Math.max(result[i+1], height[i]);
        }
        return result;
    }
}