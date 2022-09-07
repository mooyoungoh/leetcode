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
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        treeStr(root, sb);
        return sb.length() > 0 ? sb.substring(1) : sb.toString();
    }

    private void treeStr(TreeNode t, StringBuffer sb) {
        if (t != null) {
            sb.append("(").append(t.val);
            if (t.left != null) {
                treeStr(t.left, sb);
                sb.append(")");
            }
            if (t.right != null) {
                if (t.left == null) {
                    sb.append("()");
                }
                treeStr(t.right, sb);
                sb.append(")");
            }
        }
    }
}