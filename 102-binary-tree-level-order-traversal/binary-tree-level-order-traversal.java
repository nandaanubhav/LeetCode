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
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(TreeNode node, int level) {
        if(node == null) return;
        if(ans.size() == level) ans.add(new ArrayList<>());
        ans.get(level).add(node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return ans;
        helper(root, 0);
        return ans;
    }
}