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
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.add(curr.val);
            curr = curr.next;
        }
        int carry = 0;
        ListNode node = null;
        while(!stack.isEmpty()) {
            int val = stack.pop();
            int nodeVal = (val * 2) + carry;
            carry = nodeVal / 10;
            nodeVal = nodeVal % 10;
            node = new ListNode(nodeVal, node);
            // prev.next = node;
            // prev = node;
        }
        if(carry >= 1) {
            node = new ListNode(carry, node);
            // prev.next = node;
        }
        // curr = psuedoHead.next;
        // prev = null;
        // while(curr != null) {
        //     ListNode temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        return node;
    }
}