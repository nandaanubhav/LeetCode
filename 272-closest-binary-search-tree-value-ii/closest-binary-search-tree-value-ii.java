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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Pair<Double, Integer> a, Pair<Double, Integer> b) {
               return Double.compare(b.getKey(), a.getKey());
            }
        });
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            pq.add((new Pair<>(Math.abs(target - curr.val), curr.val)));
            if(pq.size() > k) pq.poll();
            if(curr.left != null) stack.add(curr.left);
            if(curr.right != null) stack.add(curr.right);
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair<Double, Integer> temp = pq.poll();
            ans.add(temp.getValue());
        }
        return ans;
    }
}