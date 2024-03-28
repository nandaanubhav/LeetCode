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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for(int i=1; i<=n; i++) {
            first = first.next;
        }
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        ListNode temp = second.next;
        second.next = second.next.next;
        temp.next = null;
        return dummy.next;
    }
}