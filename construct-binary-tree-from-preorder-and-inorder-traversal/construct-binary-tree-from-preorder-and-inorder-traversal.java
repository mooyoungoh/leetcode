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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        
        TreeNode root = new TreeNode(preorder[index++]);

        int i = 0;
        while(root.val != inorder[i]){
            i++;
        }

        root.left = helper(preorder, inorder, start, i - 1);
        root.right = helper(preorder, inorder, i + 1, end);

        return root;
    }
}