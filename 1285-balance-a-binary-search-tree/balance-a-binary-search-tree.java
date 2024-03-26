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
    private void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        inOrder.add(node.val);
        inOrder(node.right);
    }
    private TreeNode drawBST(int l, int r) {
        if(l > r) return null;
        int mid = l + (r - l)/2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = drawBST(l, mid - 1);
        root.right = drawBST(mid + 1, r);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        inOrder = new ArrayList<>();
        inOrder(root);
        return drawBST(0, inOrder.size() - 1);
    }
}