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
    List<Integer> ans;
    int currStreak;
    int maxStreak;
    int currVal;

    private void dfs(TreeNode curr) {

        if(curr == null) return;

        if(curr.left != null) dfs(curr.left);

        if(curr.val != currVal) {
            currVal = curr.val;
            currStreak = 1;
        } else {
            currStreak += 1;
        }
        if(currStreak > maxStreak) {
            ans = new ArrayList<>();
            maxStreak = currStreak;
        }
        if(currStreak == maxStreak) {
            ans.add(curr.val);
        }

        if(curr.right != null) dfs(curr.right); 

    }
    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        currStreak = 0;
        maxStreak = 0;
        currVal = 0;
    
        dfs(root);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}