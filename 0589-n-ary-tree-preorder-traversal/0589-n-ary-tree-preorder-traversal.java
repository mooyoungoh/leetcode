/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        treverse(root, ret);
        return ret;
    }
    public void treverse(Node root, List<Integer> ret){
        if(root == null){
            return;
        }
        ret.add(root.val);
        for(Node child : root.children){
            treverse(child, ret);
        }
    }
}