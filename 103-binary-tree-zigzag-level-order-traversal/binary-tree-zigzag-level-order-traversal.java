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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftFirst = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.removeFirst();
                currLevel.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(!leftFirst) {
                ans.add(currLevel.reversed());
            } else {
                ans.add(currLevel);
            }
            currLevel = new LinkedList<>();
            leftFirst = !leftFirst;

        }
        return ans;
    }
}