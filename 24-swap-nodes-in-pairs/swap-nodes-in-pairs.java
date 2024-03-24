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
    private void swapNodes(ListNode prev, ListNode curr, ListNode next) {
        prev.next = next;
        curr.next = next.next;
        next.next = curr;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head, prev = new ListNode(-1), newHead = prev;;
        while(curr != null && curr.next != null) {
            swapNodes(prev, curr, curr.next);
            prev = curr;
            curr = curr.next;
        }
        return newHead.next;
    }
}