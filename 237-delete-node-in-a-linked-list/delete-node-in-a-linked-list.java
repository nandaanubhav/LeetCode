/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node, curr = node.next; 
        while(curr.next != null) {
            int temp = prev.val;
            prev.val = curr.val;
            curr.val = temp;
            prev = curr;
            curr = curr.next;
        }
        prev.val = curr.val;
        prev.next = null;
    }
}