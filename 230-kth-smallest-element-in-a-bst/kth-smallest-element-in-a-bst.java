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
    List<Integer> inOrderTraversal;
    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.left);
        inOrderTraversal.add(node.val);
        helper(node.right);
        return ;
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal = new ArrayList<>();
        helper(root);
        return inOrderTraversal.get(k-1);
    }
}