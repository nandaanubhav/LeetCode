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
    int sum = 0, maxLevel = 0;
    private void dfs(TreeNode node, int level) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            if(level > maxLevel) {
                sum = node.val;
                maxLevel = level;
            } else if (level == maxLevel) sum += node.val;
        }
        if(node.left != null) dfs(node.left, level + 1);
        if(node.right != null) dfs(node.right, level + 1);
    }
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}