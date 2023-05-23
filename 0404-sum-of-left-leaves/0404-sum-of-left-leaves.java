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
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    private boolean dfs(TreeNode root){
        if(root == null) return false;
        if(root.left != null){
            boolean res = dfs(root.left);
            if(res) ans += root.left.val;
        }
        if(root.right != null){
            dfs(root.right);
        }
        return root.left == null && root.right == null;
    }    
}