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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public int helper(TreeNode node, List<List<Integer>> res){
        if(node == null) return -1;
        
        int level = 1 + Math.max(helper(node.left, res), helper(node.right ,res));
        
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(node.val);
        return level;
    }
}