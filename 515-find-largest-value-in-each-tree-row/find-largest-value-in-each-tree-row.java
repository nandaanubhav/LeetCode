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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int minVal = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.remove();
                minVal = Math.max(minVal, curr.val);
                // System.out.println(curr.val);
                if(curr.left != null) queue.add(curr.left); 
                if(curr.right != null) queue.add(curr.right); 
            }
            // System.out.println("Moving to new level");
            result.add(minVal);
        }
        return result;
    }
}