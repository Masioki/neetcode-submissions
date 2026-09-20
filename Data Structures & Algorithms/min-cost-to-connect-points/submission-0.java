class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes = points.length;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        // [from point idx, to point idx]
        // from is always connected to mst
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(e -> distance(e[0], e[1], points)));
        for(int i = 1; i < nodes; i++){
            queue.add(new int[]{0, i});
        }

        int result = 0;
        while(!queue.isEmpty() && visited.size() < nodes){
            int[] shortest = queue.poll();
            if(visited.contains(shortest[1])){
                continue;
            }
            visited.add(shortest[1]);
            result += distance(shortest[0], shortest[1], points);
            for(int i = 1; i<nodes; i++){
                if(!visited.contains(i)){
                    queue.add(new int[]{shortest[1], i});
                }
            }
        }
        return result;
    }

    private int distance(int n1, int n2, int[][] points){
        int[] c1 = points[n1];
        int[] c2 = points[n2];
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }
}
