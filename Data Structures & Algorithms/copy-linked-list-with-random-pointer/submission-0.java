/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
   public Node copyRandomList(Node head) {
    if (head == null) {
      return head;
    }

    List<Node> newNodes = new ArrayList<>();
    Map<Node, Integer> originalIndexes = new HashMap<>();
    Set<Node> skipped = new HashSet<>();
    Node newHead = new Node(0);
    Node resultHead = newHead;
    int index = 0;
    while (head != null) {
      var newNode = new Node(head.val);
      originalIndexes.put(head, index);
      newNodes.add(newNode);
      if (head.random != null) {
        skipped.add(head);
      }

      newHead.next = newNode;
      newHead = newNode;
      head = head.next;
      index++;
    }

    for (var skip : skipped) {
      var indexOfSkipped = originalIndexes.get(skip);
      var indexOfRandom = originalIndexes.get(skip.random);
      newNodes.get(indexOfSkipped).random = newNodes.get(indexOfRandom);
    }

    return resultHead.next;
  }
}
