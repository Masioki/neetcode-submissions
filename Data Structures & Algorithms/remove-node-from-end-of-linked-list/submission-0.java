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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        var resultHead = head;
        int index = 1;
        ListNode prevNodeToRemove = null;
        ListNode nodeToRemove = null;
        while(head != null){
            if(index == n) {
                nodeToRemove = resultHead;
            }

            if(index > n) {
                nodeToRemove = nodeToRemove.next;
                if(index == n + 1 ){
                    prevNodeToRemove = resultHead;
                } else {
                    prevNodeToRemove = prevNodeToRemove.next;
                }
            }
            head = head.next;
            index++;
        }
        
        if(nodeToRemove != null){
            if(prevNodeToRemove == null){
                resultHead = nodeToRemove.next;
            } else {
                prevNodeToRemove.next = nodeToRemove.next;
            }
        }
        return resultHead;
    }
}
