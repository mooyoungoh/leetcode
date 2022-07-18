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
    
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;
    }
    
    private boolean helper(TreeNode root){
        if(root == null)return false;
        
        if(root.left != null){
            boolean isLeaf = helper(root.left);
            if(isLeaf) sum+= root.left.val;
        }
        
        if(root.right != null) helper(root.right);
        
        return root.left==null && root.right==null;
    }
}