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
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        tra(root, result);
        return result[0];
    }

    int[] tra(TreeNode root, int[] result){
        if(root == null) return new int[]{0,0};
        
        int[] left = tra(root.left, result);
        int[] right = tra(root.right, result);
        int curSum = left[0] + right[0] + root.val;
        int curCount = left[1] + right[1] + 1;

        if(curSum / curCount == root.val) result[0]++;

        return new int[]{curSum, curCount};
    }
}