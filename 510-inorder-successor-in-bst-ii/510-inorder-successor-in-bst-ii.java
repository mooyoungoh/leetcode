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
    public Node inorderSuccessor(Node node) {
        if(node == null)
            return null;
        if(node.right != null){
            return getLeft(node.right);
        }
        return getParent(node);
    }
    
    private Node getLeft(Node node){
        if(node.left == null)
            return node;
        return getLeft(node.left);
    }
    
    private Node getParent(Node node){
        if(node.parent == null)
            return null;
        if(node == node.parent.right)
            return getParent(node.parent);
        return node.parent;
    }
}