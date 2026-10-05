class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // [height, startedAt]
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int currentHeight = heights[i];
            int indexFrom = i;
            while(!stack.isEmpty() && stack.peek()[0] > currentHeight){
                int[] biggest = stack.pop();
                indexFrom = biggest[1];
                max = Math.max(max, biggest[0] * (i - biggest[1]));
            }
            if(stack.isEmpty() || stack.peek()[0] < currentHeight){
                stack.add(new int[]{currentHeight, indexFrom});
            }
        }

        while(!stack.isEmpty()){
            int biggest[] = stack.pop();
            max = Math.max(max, biggest[0] * (heights.length  - biggest[1]));
        }
        return max;
    }
}