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

    public boolean helper(TreeNode root, boolean isLowerExist, boolean isUpperExist, int lower, int upper){
        if(root == null) return true;
        
        if(isLowerExist && root.val <= lower){
            return false;
        }

        if(isUpperExist && root.val >= upper){
            return false;
        }

        return helper(root.left, isLowerExist, true, lower, root.val) && helper(root.right, true, isUpperExist, root.val, upper );
    }
}