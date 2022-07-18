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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        boolean flag = true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            int size = s.size();
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                // children
                TreeNode node = s.pop();
                list.add(node.val);
                if(flag){
                    if(node.left!=null) newStack.push(node.left);
                    if(node.right!=null) newStack.push(node.right);
                }else{
                    if(node.right!=null) newStack.push(node.right);
                    if(node.left!=null) newStack.push(node.left);
                }
            }
            flag = !flag;
            s = newStack;
            ans.add(list);
        }
        return ans;
    }
}