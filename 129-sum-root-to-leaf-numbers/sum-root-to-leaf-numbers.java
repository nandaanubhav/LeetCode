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
    int totalSum = 0;
    private void dfs(TreeNode node, StringBuilder sb) {
        if(node == null) {
            return;
        }
        sb.append(node.val);
        if(node.left == null && node.right == null) {
            totalSum += Integer.valueOf(sb.toString());
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return totalSum;
    }
}