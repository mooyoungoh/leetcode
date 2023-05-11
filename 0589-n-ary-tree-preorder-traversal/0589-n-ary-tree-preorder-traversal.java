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
        
        if(root == null) return ret;
        
        Stack<Node> s = new Stack<>();
        s.add(root);
        
        while(!s.isEmpty()){
            Node child = s.pop();
            ret.add(child.val);
            int size = child.children.size();
            for(int i = size - 1; i>=0; i--){
                s.add(child.children.get(i));
            }
            
        }
        return ret;   
    }
}