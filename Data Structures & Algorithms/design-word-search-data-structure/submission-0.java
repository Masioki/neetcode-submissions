class WordDictionary {
private final TrieNode head;
    public WordDictionary() {
head = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = head;
        for(char c : word.toCharArray()){
            int index = toIndex(c);
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Queue<TrieNode> nodes = new ArrayDeque<>();
        nodes.add(head);
        for(char c : word.toCharArray()){
            int size = nodes.size();
            if(isMatchAll(c)){
                for(int i = 0; i <size; i++){
                    TrieNode node = nodes.poll();
                    for(TrieNode child : node.children){
                        if(child != null){
                            nodes.add(child);
                        }
                    }
                }
            } else {
                int index = toIndex(c);
                for(int i = 0; i <size; i++){
                    TrieNode nextNode = nodes.poll();
                    if(nextNode.children[index] != null){
                        nodes.add(nextNode.children[index]);
                    }
                }
            }
        }
        while(!nodes.isEmpty()){
            if(nodes.poll().isWord) return true;
        }
        return false;
    }

    private int toIndex(char c){
        return c - 'a';
    }

    private boolean isMatchAll(char c){
        return c == '.';
    }
}


class TrieNode {
    private final TrieNode[] children = new TrieNode[26];
    private boolean isWord = false;
}