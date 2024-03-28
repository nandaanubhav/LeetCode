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
    HashMap<Long, Integer> map = new HashMap<>();
    int count = 0;
    private void pathSumUtil(TreeNode node, long pathSum, int targetSum) {
        if(node == null) return;
        pathSum += node.val;
        if(map.containsKey(pathSum - targetSum)) {
            // System.out.println("Found match at " + node.val);
            count += map.get(pathSum - targetSum);
        }
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        pathSumUtil(node.left, pathSum, targetSum);
        pathSumUtil(node.right, pathSum, targetSum);
        map.put(pathSum, map.getOrDefault(pathSum, 0) - 1);
        // pathSum -= node.val;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        map.put(0L, 1);
        pathSumUtil(root, 0L, targetSum);
        return count;
    }
}