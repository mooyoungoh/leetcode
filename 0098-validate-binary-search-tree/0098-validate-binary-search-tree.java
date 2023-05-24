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
        return isValid(root, false, false, 0, 0);
    }
    private boolean isValid(TreeNode root, boolean isLowerBound, boolean isUpperBound, int lowerBound, int upperBound){
        if(root == null) return true;
        if(isLowerBound && root.val <= lowerBound ){
            return false;
        }
        if(isUpperBound && root.val >= upperBound){
            return false;
        }
        return isValid(root.left, isLowerBound, true, lowerBound, root.val) &&
            isValid(root.right, true, isUpperBound, root.val, upperBound);
    }
}