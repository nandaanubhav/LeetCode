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
    private int findLCA(TreeNode node, TreeNode[] nodes) {
        if(node == null) return 0;
        int mid = 0;
        int left = findLCA(node.left, nodes);
        int right = findLCA(node.right, nodes);
        for(int i=0; i<nodes.length; i++) {
            if(nodes[i] == node) {
                mid++;
                break;
            }
        }
        int sum = left + right + mid;
        if(sum == nodes.length && ans == null) ans = node;
        return left + right + mid;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        findLCA(root, nodes);
        return ans;
    }
}