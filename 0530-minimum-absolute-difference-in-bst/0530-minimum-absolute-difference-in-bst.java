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
    int min = Integer.MAX_VALUE;
    int prev = 0;
    boolean init = false;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;    
    }

    public void helper(TreeNode root){
        if(root == null) return;
        if(root.left != null) helper(root.left);  
        if(!init){
            prev = root.val;
            init = true;
        }else{
            min = Math.min(min, root.val - prev);
            prev = root.val;
        }
        
        
        if(root.right != null) helper(root.right);
    }
}