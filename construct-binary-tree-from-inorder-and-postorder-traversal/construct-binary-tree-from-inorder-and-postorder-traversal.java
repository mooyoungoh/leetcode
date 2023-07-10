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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);    
    }
    
    TreeNode helper(int[] inorder, int[] postorder, int ppos, int is, int ie){
      if(ppos >= postorder.length || is > ie) return null;
      TreeNode node = new TreeNode(postorder[ppos]);
      int pii = 0;
      for(int i = 0; i < inorder.length; i++){
        if(inorder[i] == postorder[ppos]) pii = i;  
      }
      node.left = helper(inorder, postorder, ppos - 1 - ie + pii, is, pii - 1);
      node.right = helper(inorder, postorder, ppos - 1 , pii + 1, ie);
      return node;
    }
}