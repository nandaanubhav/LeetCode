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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.add(new Pair<TreeNode, Integer>(root, column));
        while(!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> currLevel = new HashMap<>();
            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                column = p.getValue();
                if(!currLevel.containsKey(column)) currLevel.put(column, new ArrayList<>());
                currLevel.get(column).add(node.val);
                if(node.left != null) queue.add(new Pair<TreeNode, Integer>(node.left, column - 1));
                if(node.right != null) queue.add(new Pair<TreeNode, Integer>(node.right, column + 1));
            }
            for(int key : currLevel.keySet()) {
                if(!columns.containsKey(key)) columns.put(key, new ArrayList<>());
                Collections.sort(currLevel.get(key));
                columns.get(key).addAll(currLevel.get(key));
            }
            currLevel = new HashMap<>();
        }
        List<Integer> keySet = new ArrayList<>(columns.keySet());
        Collections.sort(keySet);
        for(int key : keySet) ans.add(columns.get(key));

        return ans;
    }
}