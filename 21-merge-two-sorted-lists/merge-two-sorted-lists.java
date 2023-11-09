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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp, prev, curr1 = list1, curr2 = list2;
        prev = head;
        while(curr1 != null && curr2 != null) {
            if(curr1.val > curr2.val) {
                temp = new ListNode(curr2.val);
                curr2 = curr2.next;
            } else {
                temp = new ListNode(curr1.val);
                curr1 = curr1.next;
            }
            prev.next = temp;
            prev = temp;
        }
        while(curr1 != null ){
            temp = new ListNode(curr1.val);
            prev.next = temp;
            prev = temp;
            curr1 = curr1.next;
        }
        while(curr2 != null ){
            temp = new ListNode(curr2.val);
            prev.next = temp;
            prev = temp;
            curr2 = curr2.next;
        }
        return head.next;
    }
}