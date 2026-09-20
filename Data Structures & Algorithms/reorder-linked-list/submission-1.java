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
        if(head == null){
            return;
        }

        Stack<ListNode> nodes = new Stack<>();
        var initialHead = head;
        int size = 0;
        while(head != null){
            nodes.add(head);
            head = head.next;
            size++;
        }
        
        head = initialHead;
        int newSize = 1;
        while(newSize < size){
            var next = head.next;
            var last = nodes.pop();
            head.next = last;
            last.next = next;
            head = next;
            if(head != null){
                newSize += 2;
            } else {
                newSize++;
            }
        }
        head.next = null;
    }
}
