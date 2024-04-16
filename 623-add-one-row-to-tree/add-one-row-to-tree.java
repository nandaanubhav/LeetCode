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
    private void dfs(TreeNode node, int depth, int val, int currDepth) {
        if(node == null) return;
        if(currDepth == depth - 1) {
            TreeNode newLeftNode = new TreeNode(val);
            newLeftNode.left = node.left;
            TreeNode newRightNode = new TreeNode(val);
            newRightNode.right = node.right;
            node.left = newLeftNode;
            node.right = newRightNode;
            return;
        }
        if(node.left != null) dfs(node.left, depth, val, currDepth + 1);
        if(node.right != null) dfs(node.right, depth, val, currDepth + 1);

    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        dfs(root, depth, val, 1);
        return root;
    }
}