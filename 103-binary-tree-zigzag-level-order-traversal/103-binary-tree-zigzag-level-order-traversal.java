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
        if(root==null)return ans;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        boolean flag = true;        
        while(!s.isEmpty()){
            int size = s.size();
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                //current level node, children
                TreeNode node = s.pop();
                level.add(node.val);
                if(flag){
                    if(node.left!=null) newStack.push(node.left);
                    if(node.right!=null) newStack.push(node.right);
                }else{
                    if(node.right!=null) newStack.push(node.right);
                    if(node.left!=null) newStack.push(node.left);
                }
            }
            ans.add(level);
            s = newStack;
            flag = !flag;
        }
        return ans;
    }
}