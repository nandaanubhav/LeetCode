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
    private void dfsUtil(TreeNode node, StringBuilder sb) {
        if(node == null) return ;
        sb.append(node.val);
        if(node.left != null) {
            sb.append('(');
            dfsUtil(node.left, sb);
            sb.append(')');
        }
        if(node.right != null) {
            if(node.left == null) sb.append('(').append(')');
            sb.append('(');
            dfsUtil(node.right, sb);
            sb.append(')');
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfsUtil(root, ans);
        return ans.toString();
    }
}