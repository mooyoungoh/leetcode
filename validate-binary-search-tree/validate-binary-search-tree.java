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

    private boolean isValid(TreeNode root, boolean isLowerBound, boolean isUpperBound, int lowerValue, int upperValue){
        if(root == null) return true;
        if(isLowerBound && root.val <= lowerValue)
            return false;
        if(isUpperBound && root.val >= upperValue)
            return false;
        
        return isValid(root.right, true, isUpperBound, root.val, upperValue) &&
        isValid(root.left, isLowerBound, true, lowerValue, root.val);
    }
}