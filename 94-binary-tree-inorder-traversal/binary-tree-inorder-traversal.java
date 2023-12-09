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
    List<Integer> inOrder;
    private void inOrderUtil(TreeNode node) {
        if(node == null) return;
        inOrderUtil(node.left);
        inOrder.add(node.val);
        inOrderUtil(node.right);
        return;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder = new ArrayList<>();
        inOrderUtil(root);
        return inOrder;
    }
}