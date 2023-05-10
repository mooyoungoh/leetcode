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
    int min;
    boolean init;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        init = false;
        inorder(root);
        return min;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(!init){
            init = true;
        }else{
            min = Math.min(min, root.val - prev);
        }
        
        prev = root.val;
        inorder(root.right);
    }
}