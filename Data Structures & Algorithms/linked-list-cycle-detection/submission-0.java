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
    public boolean hasCycle(ListNode head) {
        Map<Integer, ListNode> cache = new HashMap<>();
        while(head != null){
            var next = head.next;
            var hash = head.hashCode();
            if(cache.containsKey(hash)){
                if(cache.get(hash) == head) {
                    return true;
                }
            } else {
                cache.put(hash, head);
            }
            head = next;
        }
        return false;
    }
}
