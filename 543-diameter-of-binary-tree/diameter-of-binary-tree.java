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
    int diameter = 0;
    ArrayList<Integer> diameterPath = new ArrayList<>();
    private Pair<Integer, ArrayList<Integer>> dfs(TreeNode node) {
        if(node == null) return new Pair<>(0, new ArrayList<>());
        Pair<Integer, ArrayList<Integer>> left = dfs(node.left);
        Pair<Integer, ArrayList<Integer>> right = dfs(node.right);
        ArrayList<Integer> currPath = new ArrayList<>();
        if(diameter < left.getKey() + right.getKey()) {
            diameter = Math.max(diameter, left.getKey() + right.getKey());
            diameterPath = (ArrayList) left.getValue().clone();
            diameterPath.add(node.val);
            diameterPath.addAll((ArrayList) right.getValue().clone());
        }

        if(left.getKey() > right.getKey()) {
            currPath = (ArrayList) left.getValue().clone();
            currPath.add(node.val);
        } else {
            currPath = (ArrayList) left.getValue().clone();
            currPath.add(node.val);
        }

        return new Pair<>(Math.max(left.getKey(), right.getKey()) + 1, currPath);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        System.out.println(diameterPath);
        return diameter;
    }
}