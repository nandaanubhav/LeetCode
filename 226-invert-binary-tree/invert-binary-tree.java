

import static java.util.stream.Collectors.reducing;

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
    private void invertNode(TreeNode node) {
        if(node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right); 
        }
        return root;
    }
}