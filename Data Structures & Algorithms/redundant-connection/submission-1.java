class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int[] degrees = new int[edges.length+1];
    Map<Integer, Set<Integer>> nextNodes = new HashMap<>();
    for(var edge : edges){
      degrees[edge[0]]++;
      degrees[edge[1]]++;
      if(!nextNodes.containsKey(edge[0])){
        nextNodes.put(edge[0], new HashSet<>());
      }
      if(!nextNodes.containsKey(edge[1])){
        nextNodes.put(edge[1], new HashSet<>());
      }
      nextNodes.get(edge[0]).add(edge[1]);
      nextNodes.get(edge[1]).add(edge[0]);
    }

    Queue<Integer> toRemove = new LinkedList<>();
    for(int i = 0; i < degrees.length; i++){
      if(degrees[i] <= 1){
        toRemove.add(i);
      }
    }

    while(!toRemove.isEmpty()){
      int nodeToRemove = toRemove.poll();
      degrees[nodeToRemove]--;
      if(nextNodes.containsKey(nodeToRemove)){
        for(int nextNode : nextNodes.get(nodeToRemove)){
          degrees[nextNode]--;
          if(degrees[nextNode] == 1){
            toRemove.add(nextNode);
          }
        }
      }
    }

    Set<Integer> nodesLeft = new HashSet<>();
    for(int i=0; i<degrees.length; i++){
      if(degrees[i] > 0){
        nodesLeft.add(i);
      }
    }
    for(int i = edges.length-1; i>=0; i--){
      if(nodesLeft.contains(edges[i][0]) && nodesLeft.contains(edges[i][1])){
        return edges[i];
      }
    }

    return new int[0];
  }
}
