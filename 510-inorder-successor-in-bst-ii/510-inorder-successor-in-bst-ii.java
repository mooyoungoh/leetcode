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
        /*
        If right subtree of node is not NULL, then succ lies in right subtree. Do the following. 
            Go to right subtree and return the node with minimum key value in the right subtree.
        */
        if(node.right != null){
            node = node.right;
            while(node != null && node.left != null){
                node = node.left;
            }
            return node;
        }
        
        /*
        If right subtree of node is NULL, then succ is one of the ancestors. Do the following. 
            Travel up using the parent pointer until you see a node which is left child of its parent. 
            The parent of such a node is the succ.
        */
        
        while(node != null){
            if(node.parent == null)
                return null;
            if(node.parent.left == node)
                return node.parent;
            else
                node = node.parent;
        }
        return node;
    }
}