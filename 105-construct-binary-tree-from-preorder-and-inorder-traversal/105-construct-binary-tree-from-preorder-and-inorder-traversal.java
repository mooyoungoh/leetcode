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
    int idx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder,int[] inorder, int start,int end){
        if(start>end) return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        int i=0;
        
        while(inorder[i] != root.val){
            i++;
        }
        root.left = helper(preorder, inorder, start, i-1);  // left-side size 
        root.right = helper(preorder, inorder, i+1, end);   // right-side size
        
        return root;
    }
}

/*

# Preorder Traversal: Root -> Left -> Right
# Inorder Traversal: Left -> Root -> Right
# Hence, at any step, first value in the preorder traversal represents
# root of the binary tree at that point.
# If that value is at the i'th index in inorder list,
# then all the values to its left are part of left subtree.
# Similarly, all the values to its right are part of the right subtree.
        
*/