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
    private void leafSequence(TreeNode node, List<Integer> leafSeq) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            leafSeq.add(node.val);
        }
        leafSequence(node.left, leafSeq);
        leafSequence(node.right, leafSeq);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Values = new ArrayList<>();
        List<Integer> root2Values = new ArrayList<>();
        leafSequence(root1, root1Values);
        leafSequence(root2, root2Values);
        return root1Values.equals(root2Values);
        
    }
}