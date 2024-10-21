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
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            ans.add(cur.val);
            for(int i = cur.children.size() - 1; i>=0; i--){
                stack.push(cur.children.get(i));
            }
        }
        return ans;
    }
}