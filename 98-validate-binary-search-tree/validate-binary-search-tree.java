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
    private boolean check(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        if((min != null && node.val <= min) || (max != null && node.val >= max) ) return false;
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        return check(root, null, null);
    }
}