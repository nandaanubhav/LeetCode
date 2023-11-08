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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev , temp, curr1 = l1, curr2 = l2;
        prev = head;
        int carry = 0;
        while(curr1 != null || curr2 != null) {
            int sum = carry;
            if(curr1 != null) sum += curr1.val;
            if(curr2 != null) sum += curr2.val;
            if(sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else carry = 0;
            temp = new ListNode(sum);
            prev.next = temp;
            prev = temp;
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        if(carry == 1) prev.next = new ListNode(1);
        return head.next;
    }
}