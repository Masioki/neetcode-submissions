class MedianFinder {
private final Queue<Integer> less;
private final Queue<Integer> more;
private double median;
    public MedianFinder() {
        this.less = new PriorityQueue<>(Comparator.reverseOrder());
        this.more = new PriorityQueue<>();
        median = Double.MIN_VALUE;
    }
    
    public void addNum(int num) {
        less.add(num);
        more.add(less.poll());

        if(less.size() < more.size()){
            less.add(more.poll());
        } 
    }
    
    public double findMedian() {
        if(less.size() == more.size()){
            return ((double) (less.peek() + more.peek())) / 2;
        }
        return less.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */