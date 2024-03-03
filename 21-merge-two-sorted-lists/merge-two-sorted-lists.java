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
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) return mergeTwoLists(list2, list1);
        ListNode curr = list1, curr1 = list1.next, curr2 = list2;

        while(curr1 != null && curr2 != null) {
            // System.out.println("Both Not null");
            if(curr1.val <= curr2.val) {
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr = curr.next;
                curr2 = curr2.next;
            }
        }
        while(curr1 != null) {
            // System.out.println("1 Not null");
            curr.next = curr1;
            curr = curr.next;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            // System.out.println("2 Not null");
            curr.next = curr2;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return list1;
    }
}