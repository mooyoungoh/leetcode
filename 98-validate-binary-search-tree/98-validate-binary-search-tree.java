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
    public boolean isValidBST(TreeNode root) {
        return helper(root, false, false, 0, 0);
    }
    
    private boolean helper(TreeNode node, boolean isLowerExist, boolean isUpperExist, int lowerBound, int upperBound){
        if(node == null) return true;
        
        //base
        if(isLowerExist && node.val <= lowerBound){
            return false;
        }
        if(isUpperExist && node.val >= upperBound){
            return false;
        }
        
        return helper(node.left, isLowerExist, true, lowerBound, node.val) 
            && helper(node.right, true, isUpperExist, node.val, upperBound) ;
    }
}