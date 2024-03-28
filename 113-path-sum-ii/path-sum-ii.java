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
    List<List<Integer>> ans;
    private void hasPathSum(TreeNode root, int targetSum, ArrayList<Integer> currSeq) {
        if(root == null) return;
        targetSum -= root.val;
        currSeq.add(root.val);
        if(root.left == null && root.right == null) {
            if(targetSum == 0) ans.add(new ArrayList<Integer>(currSeq));
        }
        hasPathSum(root.left, targetSum, currSeq);
        hasPathSum(root.right, targetSum, currSeq);
        currSeq.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        hasPathSum(root, targetSum, new ArrayList<>());
        return ans;
    }
}