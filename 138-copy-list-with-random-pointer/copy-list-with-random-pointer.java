/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    private Node cloneList(Node node) {
        if(node == null) return null;
        Node clonedNode = new Node(node.val);
        clonedNode.next = cloneList(node.next);
        map.put(node, clonedNode);
        return clonedNode;
    }
    public void copyRandomPointers(Node node) {
        if(node == null) return;
        Node randomNode = node.random;
        Node clonedNode = map.get(node);
        clonedNode.random = map.get(randomNode);
        copyRandomPointers(node.next);
    }
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node newHead = cloneList(curr);
        copyRandomPointers(curr);
        return newHead;
    }
}