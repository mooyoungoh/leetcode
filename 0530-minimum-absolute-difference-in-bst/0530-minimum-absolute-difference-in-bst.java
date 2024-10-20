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
    int min = Integer.MAX_VALUE;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root){
     if(root == null) return;
     inorder(root.left);
     //self;
     if(init == false){
        init = true;
        prev = root.val;
     }else{
        min = Math.min(min, root.val - prev);
        prev = root.val;
     }
     inorder(root.right);
    }
}