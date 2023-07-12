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
    int k;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        if(root.left != null) helper(root.left);
        if(--k == 0){
            ans = root.val;
            return;
        }
        if(root.right != null) helper(root.right);
    }
}