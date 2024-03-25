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
    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}