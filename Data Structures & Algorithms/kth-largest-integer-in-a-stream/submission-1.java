class KthLargest {
   private final Queue<Integer> queue;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for(int n : nums){
            queue.add(n);
        }
        while(queue.size() > k){
            queue.poll();
        }
    }
    
    public int add(int val) {
        if(queue.size() < k){
            queue.add(val);
        } else if(queue.peek() <= val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
