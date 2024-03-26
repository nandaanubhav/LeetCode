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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode drawBST(List<Integer> inOrder, int l, int r) {
        if(l > r) return null;
        int m = l + (r - l)/2;
        TreeNode root = new TreeNode(inOrder.get(m));
        root.left = drawBST(inOrder, l, m - 1);
        root.right = drawBST(inOrder, m + 1, r);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> inOrder = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            inOrder.add(curr.val);
            curr = curr.next;
        }
        return drawBST(inOrder, 0, inOrder.size() - 1);
    }
}