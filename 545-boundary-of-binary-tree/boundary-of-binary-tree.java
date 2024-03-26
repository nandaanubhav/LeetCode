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
    List<Integer> boundry;
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
    private void addLeafNodes(TreeNode node) {
        if(node == null) return;
        if(isLeafNode(node)) boundry.add(node.val);
        addLeafNodes(node.left);
        addLeafNodes(node.right);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<>();
        boundry = new ArrayList<>();
        if(!isLeafNode(root)) boundry.add(root.val);
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeafNode(curr)) boundry.add(curr.val);
            if(curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        addLeafNodes(root);
        curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while(curr != null) {
            if(!isLeafNode(curr)) stack.add(curr.val);
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while(!stack.isEmpty()) boundry.add(stack.pop());
        return boundry;
    }
}