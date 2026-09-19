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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        var start = head;
        ListNode next = head;
        head = head.next;
        while(head != null){
            var newHead = head.next;
            head.next = next;
            next = head;
            head = newHead;
        }
        start.next = null;

        return next;
    }
}
