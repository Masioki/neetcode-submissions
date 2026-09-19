class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s : stones){
            queue.add(s);
        }
        while(queue.size() > 1){
            int bigger = queue.poll();
            int smaller = queue.poll();
            int result = bigger - smaller;
            if(result > 0){
                queue.add(result);
            }
        }
        if(queue.isEmpty()){
            return 0;
        }
        return queue.poll();
    }
}
