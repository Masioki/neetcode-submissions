class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> nodes;
    private Node head;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = new HashMap<>();
        this.size = 0;
    }
    
    public int get(int key) {
        int value = remove(key);
        if(value < 0){
            return value;
        }
        put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        remove(key);
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.next = head;
        if (head != null) { // prev new head
            newNode.prev = head.prev;
            head.prev = newNode;
            newNode.prev.next = newNode;
        } else {
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        head = newNode;
        nodes.put(key, newNode);
        size++;
        if(size > capacity){
            remove(head.prev.key);
        }
    }

private int remove(int key){
        Node node = nodes.remove(key);
        if(node == null) return -1;
        
        // NAPRAWA: Jeśli usuwamy ostatni element, ustawiamy head na null
        if (node == head && node.next == head) {
            head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            if(node == head){
                head = node.next;    
            }
        }
        
        node.next = null;
        node.prev = null;
        size--;
        return node.value;
    }

    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */