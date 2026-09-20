class Solution {
    public int[][] kClosest(int[][] points, int k) {
        double[] distances = new double[points.length];
        Queue<Integer> closestIdx = new PriorityQueue<>(Comparator.comparing(i -> -distances[i]));
        for(int i = 0; i < points.length; i++){
            distances[i] = distance(points[i]);
            closestIdx.add(i);
            if(closestIdx.size() > k){
                closestIdx.poll();
            }
        }
        
        int[][] result = new int[closestIdx.size()][2];
        int size = closestIdx.size();
        for(int i = 0; i < size; i++){
            result[i] = points[closestIdx.poll()];
        }
        return result;
    }

    private double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
