/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    private boolean findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;

        int left = findLCA(node.left, p, q) ? 1 : 0;
        int right = findLCA(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if(left + mid + right == 2) ans = node;
        return left + mid + right > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return ans;
    }
}