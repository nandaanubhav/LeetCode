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
    int index = 0;
    private TreeNode bstFromPreorderUtil(int[] preOrder, int min, int max) {
        if(index == preOrder.length) return null;
        if(preOrder[index] < min || preOrder[index] > max) return null;
        int rootVal = preOrder[index++];
        TreeNode root = new TreeNode(rootVal);
        root.left = bstFromPreorderUtil(preOrder, min, rootVal);
        root.right = bstFromPreorderUtil(preOrder, rootVal, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}