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
    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if(left > right) return null;
        if(postorderIndex < 0) return null;
        int rootElement = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootElement);
        root.right = arrayToTree(postorder, inorderIndexMap.get(rootElement) + 1, right);
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootElement) - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, postorder.length - 1);

    }
}