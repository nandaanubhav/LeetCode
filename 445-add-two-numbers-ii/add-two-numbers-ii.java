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
        ListNode curr = l1;
        Stack<Integer> stack1 = new Stack<>();
        while(curr != null) {
            stack1.add(curr.val);
            curr = curr.next;
        }
        curr = l2;
        Stack<Integer> stack2 = new Stack<>();
        while(curr != null) {
            stack2.add(curr.val);
            curr = curr.next;
        }
        int carry = 0, sum = 0;
        Stack<Integer> ans = new Stack<>();
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();            
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            sum = carry;
        }
        if(carry != 0) ans.add(carry);
        ListNode newHead = new ListNode(-1);
        curr = newHead;
        while(!ans.isEmpty()) {
            ListNode node = new ListNode(ans.pop());
            curr.next = node;
            curr = curr.next;
        }
        return newHead.next;
    }
}