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
        treverse(root);
        return ans;
    }
    
    public void treverse(TreeNode root){
        if(root == null) return;
        treverse(root.left);
        if(--k == 0){
            ans = root.val;
        }
        treverse(root.right);
    }
}