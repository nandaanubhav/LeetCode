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
    String smallestString;
    private void dfs(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        sb.insert(0, (char) (node.val + 'a'));
        System.out.println(sb.toString());
        if(node.left == null && node.right == null) {
            if(sb.toString().compareTo(smallestString) < 0 || smallestString.equals("")) {
                smallestString = sb.toString();
            }
        }
        if(node.left != null) dfs(node.left, sb);
        if(node.right != null) dfs(node.right, sb);
        sb.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        smallestString = "";
        dfs(root, new StringBuilder());
        return smallestString;
    }
}