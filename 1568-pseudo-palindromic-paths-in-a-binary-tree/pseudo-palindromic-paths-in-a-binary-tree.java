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
    int ans = 0;
    private boolean isPsuedoPalindrome(int[] seq) {
        boolean oddLength = false;
        for(int i=0; i<seq.length; i++) {
            // System.out.print(i + "-" + seq[i] + " ");
            if(seq[i] % 2 != 0) {
                if(oddLength) return false;
                oddLength = true;
            }
        }
        // System.out.println("return true");
        return true;
    }
    private void dfs(TreeNode node, int[] currSeq) {
        if(node == null) {
            return;
        }
        currSeq[node.val]++;
        if(node.left == null && node.right == null) {
            if(isPsuedoPalindrome(currSeq)) {
                ans++;
            }
            currSeq[node.val]--;
            return;

        }
        dfs(node.left, currSeq);
        dfs(node.right, currSeq);
        currSeq[node.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new int[10]);
        return ans;
    }
}