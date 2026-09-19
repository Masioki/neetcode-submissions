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
   public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null){
      return null;
    }

    List<ListNode[]> sublists = new LinkedList<>();

    int index = 1;
    var currentHead = head;
    while(head != null) {
      var next = head.next;
      if(index % k == 0){
        head.next = null;
        var newSublistHead = reverse(currentHead);
        sublists.add(new ListNode[]{newSublistHead, currentHead});
        currentHead = next;
      }
      head = next;
      index++;
    }
    if(currentHead != null){
      sublists.add(new ListNode[]{currentHead, null});
    }

    var resultHead = sublists.get(0)[0];
    for(int i=0; i < sublists.size() - 1; i++){
      sublists.get(i)[1].next = sublists.get(i+1)[0];
    }

    return resultHead;
  }

  private ListNode reverse(ListNode head){
    if(head.next == null){
      return head;
    }
    var prev = head;
    head = head.next;
    prev.next = null;
    while(head != null){
      var nextHead = head.next;
      head.next = prev;
      prev = head;
      head = nextHead;
    }
    return prev;
  }
}
