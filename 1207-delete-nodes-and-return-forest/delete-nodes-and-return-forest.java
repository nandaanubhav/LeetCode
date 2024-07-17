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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return new ArrayList<>();
        Set<Integer> toDelSet = new HashSet<>();
        for(int i : to_delete) toDelSet.add(i);

        List<TreeNode> forest = new ArrayList<>();

        root = process(root, toDelSet, forest);

        if(root != null) forest.add(root);

        return forest;
    }

    private TreeNode process(TreeNode node, Set<Integer> toDelSet, List<TreeNode> forest) {
        if(node == null) return null;

        node.left = process(node.left, toDelSet, forest);
        node.right = process(node.right, toDelSet, forest);

        if(toDelSet.contains(node.val)) {
            if(node.left != null) forest.add(node.left);
            if(node.right != null) forest.add(node.right);

            return null;
        }

        return node;
    }
}