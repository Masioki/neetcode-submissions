class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Set<Integer>> adjecent = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adjecent.add(new HashSet<>());
        }

        for(int[] edge : edges){
            adjecent.get(edge[0]).add(edge[1]);
            adjecent.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components++;
                collectNodes(i, visited, adjecent);
            }
        }
        return components;
    }

    private void collectNodes(int node, boolean[] visited, List<Set<Integer>> adjecent){
        visited[node] = true;
        for(int neighbour : adjecent.get(node)){
            if(!visited[neighbour]){
                collectNodes(neighbour, visited, adjecent);
            }
        }
    }
}
