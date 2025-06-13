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
    boolean init = false;
    int ans = Integer.MAX_VALUE;
    int prev = 0;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode node){
        if(node == null) return;
        if(node.left != null) inorder(node.left);
        if(!init){
            init = true;
            prev = node.val;
        }else{
            ans = Math.min(ans, node.val - prev);
            prev = node.val;
        }
        if(node.right != null) inorder(node.right);
    }
}