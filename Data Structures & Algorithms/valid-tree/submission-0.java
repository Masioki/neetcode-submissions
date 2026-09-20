class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        for(int i=0; i < n; i++){
            neighbours.put(i, new HashSet<>());
        }

        for(int[] edge : edges){
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> toRemove = new ArrayDeque<>();
        for(int node : neighbours.keySet()){
            if(degree(neighbours, node) <= 1){
                toRemove.add(node);
            }
        }

        while(!toRemove.isEmpty()){
            int size = toRemove.size();
            for(int i = 0; i < size; i++){
                int node = toRemove.poll();
                int degree = degree(neighbours, node);
                for(int nodeToRemove : remove(neighbours, node)){
                    toRemove.add(nodeToRemove);
                }
                if(degree == 0){
                    return neighbours.isEmpty();
                }
            }
        }

        return neighbours.isEmpty();
    }

    private List<Integer> remove(Map<Integer, Set<Integer>> neighbours, int node) {
        List<Integer> result = new ArrayList<>();
        for(int neighbour : neighbours.remove(node)){
            neighbours.get(neighbour).remove(node);
            if(degree(neighbours, neighbour) <= 1){
                result.add(neighbour);
            }
        }
        return result;
    }

    private int degree(Map<Integer, Set<Integer>> neighbours, int node){
        return neighbours.get(node).size();
    }
}
