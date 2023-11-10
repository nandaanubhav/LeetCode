/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    HashSet<Integer> nodeList;
    private int findLCA(TreeNode node, TreeNode[] nodes) {
        if(node == null) return 0;
        int mid = 0;
        int left = findLCA(node.left, nodes);
        int right = findLCA(node.right, nodes);
        if(nodeList.contains(node.val)) mid = 1;
        int sum = left + right + mid;
        if(sum == nodes.length && ans == null) ans = node;
        return left + right + mid;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        nodeList = new HashSet<>();
        for(int i=0; i<nodes.length; i++) nodeList.add(nodes[i].val);
        findLCA(root, nodes);
        return ans;
    }
}