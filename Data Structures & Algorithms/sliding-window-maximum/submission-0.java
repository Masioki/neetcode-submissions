class Solution {
 public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k){
            return null;
        }

        int[] result = new int[nums.length - k + 1];
        int windowIndex = 0;
        // bigger -> smaller
        // index of biggest -> rest
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i <k; i++){
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekFirst()]){
                queue.pollFirst();
            }
            queue.addFirst(i);
        }
        result[windowIndex] = nums[queue.peekLast()];
        windowIndex++;
        while(windowIndex < result.length){
            if(queue.peekLast() == windowIndex - 1){
                queue.pollLast();
            }
            int index = windowIndex + k -1;
            while(!queue.isEmpty() && nums[index] >= nums[queue.peekFirst()]){
                queue.pollFirst();
            }
            queue.addFirst(index);
            result[windowIndex] = nums[queue.peekLast()];
            windowIndex++;
        }
        return result;
    }
}
