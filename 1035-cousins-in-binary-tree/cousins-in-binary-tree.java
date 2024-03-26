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
    private Pair<Integer, Integer> dfs(TreeNode node, int target, TreeNode parent, int depth) {
        if(node == null) return new Pair<>(0, 0);
        if(node.val == target) {
            return new Pair<>(depth, parent.val);
        }
        Pair<Integer, Integer> val = dfs(node.left, target, node, depth + 1);
        if(val.getKey() == 0) val = dfs(node.right, target, node, depth + 1);
        return val;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y) return false;
        Pair<Integer, Integer> xVal = dfs(root, x, new TreeNode(-1), 0);
        Pair<Integer, Integer> yVal = dfs(root, y, new TreeNode(-1), 0);
        return xVal.getKey() == yVal.getKey() && xVal.getValue() != yVal.getValue();

    }
}