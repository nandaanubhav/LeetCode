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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head.next, prev = head;
        while(curr != null) {
            if(curr.val == prev.val) {
                prev.next = curr.next;
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
            
        }
        return head;
    }
}