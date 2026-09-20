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
    public void reorderList(ListNode head) {
        LinkedList<ListNode> nodes = new LinkedList<>();

        while(head != null){
            nodes.add(head);
            head = head.next;
        }

        head = new ListNode();
        while(!nodes.isEmpty()){
            var first = nodes.removeFirst();
            ListNode second = null;
            if(!nodes.isEmpty()){
                second = nodes.removeLast();
                second.next = null;
            }
            head.next = first;
            first.next = second;
            head = second;
        }
    }
}
