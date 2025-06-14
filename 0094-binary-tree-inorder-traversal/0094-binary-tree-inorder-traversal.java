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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        treversal(root, ans);
        return ans;
    }
    public void treversal(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(node.left != null) treversal(node.left, ans);
        ans.add(node.val);
        if(node.right != null) treversal(node.right, ans);
    }
}