/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node, NodeCopy> map = new HashMap<>();
    private NodeCopy deepCopy(Node node) {
        if(node == null) return null;
        NodeCopy root = new NodeCopy(node.val);
        root.left = deepCopy(node.left);
        root.right = deepCopy(node.right);
        map.put(node, root);
        return root;
    }

    private void mapRandomPointers(Node old) {
        if(old == null) return;

        NodeCopy newNode = map.get(old);
        Node oldRandom = old.random;
        NodeCopy newRandom = map.get(oldRandom);
        newNode.random = newRandom;

        mapRandomPointers(old.left);
        mapRandomPointers(old.right);
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy newRoot = deepCopy(root);
        mapRandomPointers(root);
        return newRoot;
    }
}