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
  private StringBuffer sb = new StringBuffer();
    private void preOrderUtil(TreeNode node) {
        if(node == null) {
          return;
        };
        sb.append(node.val);
        if (node.left != null) {
            sb.append("(");
            preOrderUtil(node.left);
            sb.append(")");        
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append("()");
            }
            sb.append("(");
            preOrderUtil(node.right);
            sb.append(")");
        }
        return;
    }
    public String tree2str(TreeNode root) {
        preOrderUtil(root);
        return sb.toString();
    }
}