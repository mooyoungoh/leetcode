/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode buildTree(int[] in, int[] post) {
    if (in == null || in.length == 0 || post == null || post.length == 0) return null; 
    return helper(post, post.length - 1, in, 0, in.length - 1);
  }
  private TreeNode helper(int[] post, int idx, int[] in, int start, int end) {
    if (start > end || idx < 0) return null; 
    TreeNode root = new TreeNode(post[idx]);
    int i;
    for (i = start; i <= end; i++) {
      if (in[i] == root.val) {
        break;
      }
    }
    root.right = helper(post, idx - 1, in, i + 1, end);
    root.left = helper(post, idx - (end - i  + 1), in, start, i - 1);
    return root;    
  }
}