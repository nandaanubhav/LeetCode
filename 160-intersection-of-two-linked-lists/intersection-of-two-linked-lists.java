/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode currA = headA, currB = headB;
        while(currA != null) {
            n++;
            currA = currA.next;
        }
        while(currB != null) {
            m++;
            currB = currB.next;
        }
        System.out.println("n " + n + " m " + m);
        currB = headB;
        currA = headA;
        while(Math.abs(m - n) > 0) {
            if(m > n) {
                m--;
                currB = currB.next;
            } else {
                n--;
                currA = currA.next;
            }
        }
        while(currA != null) {
            if(currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}