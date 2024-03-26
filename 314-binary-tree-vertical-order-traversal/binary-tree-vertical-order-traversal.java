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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.add(new Pair<TreeNode, Integer>(root, column));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode node = p.getKey();
                column = p.getValue();
                if(!columnTable.containsKey(column)) columnTable.put(column, new ArrayList<>());
                columnTable.get(column).add(node.val);
                if(node.left != null) queue.add(new Pair<TreeNode, Integer>(node.left, column - 1));
                if(node.right != null) queue.add(new Pair<TreeNode, Integer>(node.right, column + 1));
            }
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            output.add(columnTable.get(k));
        }
        return output;
    }
}