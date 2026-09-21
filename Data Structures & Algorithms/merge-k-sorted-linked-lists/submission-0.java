/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if(lists == null || lists.length == 0){
        return null;
      }
      ListNode initialHead = new ListNode();
      ListNode head = initialHead; // dummy
      Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(n -> n.val));
      for(var list : lists){
        if(list == null){
          continue;
        }
        queue.add(list);
      }

      while(!queue.isEmpty()){
        var nextNode = queue.poll();
        head.next = nextNode;
        if(nextNode.next != null){
          queue.add(nextNode.next);
        }
        nextNode.next = null;
        head = head.next;
      }
      return initialHead.next;
  }
}
