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
    private int dfsUtil(TreeNode node) {
        if(node == null) return 0;
        return Math.max(dfsUtil(node.left), dfsUtil(node.right)) + 1;
    }
    public int maxDepth(TreeNode root) {
        // if(root == null) return 0;
        // int depth = 0;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     depth++;
        //     for(int i=0; i<size;i++) {
        //         TreeNode curr = queue.poll();
        //         if(curr.left != null) queue.add(curr.left);
        //         if(curr.right != null) queue.add(curr.right);
        //     }
        // }
        // return depth;
        return dfsUtil(root);
    }
}