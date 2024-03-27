/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        // boolean cycle = false;
        // while(fastPtr != null && fastPtr.next != null) {
        //     if(fastPtr == slowPtr) {
        //         cycle = true;
        //         break;
        //     }
        //     slowPtr = slowPtr.next;
        //     fastPtr = fastPtr.next.next;
        // }
        // if(!cycle) return null;
        HashSet<ListNode> nodesSeen = new HashSet<>();
        slowPtr = head;
        while(slowPtr != null) {
            if(nodesSeen.contains(slowPtr)) return slowPtr;
            nodesSeen.add(slowPtr);
            slowPtr = slowPtr.next;
        }

        return null;
    }
}