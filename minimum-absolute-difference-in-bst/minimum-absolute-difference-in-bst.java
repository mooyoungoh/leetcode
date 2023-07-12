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
    int ans = Integer.MAX_VALUE;
    int prev;
    boolean init = false;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        if(root.left != null) helper(root.left);
        if(!init){
            init = true;
            prev = root.val;
        }else{
            ans = Math.min(root.val - prev, ans);
            prev = root.val;
        } 
        if(root.right != null) helper(root.right);
    }
}