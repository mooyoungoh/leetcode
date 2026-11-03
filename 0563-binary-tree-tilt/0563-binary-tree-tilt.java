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
    public int findTilt(TreeNode root) {
        
        dfs(root);

        return ans;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        ans += Math.abs(left - right);

        return left + right + node.val;
        
    }
}