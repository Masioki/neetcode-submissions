class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] weights = new int[n][n];
        List<Set<Integer>> adjecent = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjecent.add(new HashSet<>());
        }
        for(int[] edge : times){
            int weight = edge[2];
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            weights[from][to] = weight;
            adjecent.get(from).add(to);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        dfs(k-1, 0, result, adjecent, weights);

        int max = 0;
        for(int res : result){
            if(res == -1){
                return -1;
            }
            max  = Math.max(res, max);
        }
        return max;
    }

    private void dfs(int node, int cost, int[] result,  List<Set<Integer>> adjecent, int[][] weights){
        if(result[node] != -1 && result[node] <= cost){
            return;
        }
        result[node] = cost;
        for(int adj : adjecent.get(node)){
            dfs(adj, cost + weights[node][adj], result, adjecent, weights);
        }
    }
}
