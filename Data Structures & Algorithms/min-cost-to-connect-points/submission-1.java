class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes = points.length;
        
        boolean[] visited = new boolean[nodes];
        visited[0] = true;
        // [from point idx, to point idx]
        // from is always connected to mst
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(e -> e[2]));
        for(int i = 1; i < nodes; i++){
            queue.add(new int[]{0, i, distance(0, i, points)});
        }

        int result = 0;
        int visitedCount = 1;
        while(!queue.isEmpty() && visitedCount < nodes){
            int[] shortest = queue.poll();
            if(visited[shortest[1]]){
                continue;
            }
            visited[shortest[1]] = true;
            visitedCount++;
            result += shortest[2];
            for(int i = 1; i<nodes; i++){
                if(!visited[i]){
                    queue.add(new int[]{shortest[1], i, distance(shortest[1], i, points)});
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
