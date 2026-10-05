class MinStack {
    private final Stack<Integer> stack;
    private final Stack<int[]> minQueue; // [index, value] of first occurence of min
    private int min; 

    public MinStack() {
     stack = new Stack<>();   
     minQueue = new Stack<>();
     min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        stack.add(value);
        if(minQueue.isEmpty() || minQueue.peek()[1] > value){
            minQueue.add(new int[]{stack.size(), value});
            min = value;
        }
    }
    
    public void pop() {
       int popped = stack.pop();
        if(!minQueue.isEmpty() && minQueue.peek()[0] > stack.size()){
            minQueue.pop();
            if(!minQueue.isEmpty()){
                min = minQueue.peek()[1];
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */