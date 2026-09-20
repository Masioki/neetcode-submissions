/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Integer, Node> nodesMap = new HashMap<>();
        return clone(node, nodesMap);
    }

    private Node clone(Node orgRoot, Map<Integer, Node> nodesMap){
        if(nodesMap.containsKey(orgRoot.val)){
            return nodesMap.get(orgRoot.val);
        }

        Node newRoot = new Node(orgRoot.val);
        nodesMap.put(newRoot.val, newRoot);
        for(var orgNeighbour : orgRoot.neighbors){
            newRoot.neighbors.add(clone(orgNeighbour, nodesMap));
        }
        return newRoot;
    }
}