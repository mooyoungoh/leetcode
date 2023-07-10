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
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return ans;
    }

    public void preorder(TreeNode node, int cur){
        if(node == null) return;
        cur = cur * 10 + node.val;
        if(node.left == null && node.right == null){
            ans += cur;
        }
        preorder(node.left, cur);
        preorder(node.right, cur);
    }
}