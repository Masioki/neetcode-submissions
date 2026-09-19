class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> next = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(var pre : prerequisites){
            if(!next.containsKey(pre[1])){
                next.put(pre[1], new HashSet<>());
            }
            next.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        
        Queue<Integer> toRemove = new LinkedList<>();
        for(int i=0; i < indegree.length; i++){
            if(indegree[i] == 0){
                toRemove.add(i);
            }
        }
        int zerodCourses =  toRemove.size();
        while(!toRemove.isEmpty()){
            int nodeToRemove = toRemove.poll();
            if(next.containsKey(nodeToRemove)){
                for(int nextNode : next.get(nodeToRemove)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] <= 0){
                        toRemove.add(nextNode);
                        zerodCourses++;
                    }
                }
            }
        }
        return zerodCourses == numCourses;
    }
}
