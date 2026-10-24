class PrefixTree {
    private final Node head;
    public PrefixTree() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node node = head;
        for(char c : word.toCharArray()){
            node = node.children.computeIfAbsent(c, d -> new Node());
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        var found = searchNode(word);
        if(found != null && found.isWord) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String prefix){
                Node node = head;
        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)) return null;
            node = node.children.get(c);
        }
        return node;
    }
}

class Node {
    final Map<Character, Node> children;
    boolean isWord;

    Node(){
        children = new HashMap<>();
        isWord = false;
    }


}
