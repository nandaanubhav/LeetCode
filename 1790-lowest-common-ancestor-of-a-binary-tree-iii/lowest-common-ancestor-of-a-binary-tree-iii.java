/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node curr1 = p, curr2 = q;
        while(curr1 != curr2) {
            curr1 = curr1.parent != null ? curr1.parent : q;
            curr2 = curr2.parent != null ? curr2.parent : p;
        }
        return curr1;
        
    }
}