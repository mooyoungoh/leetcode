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
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxi = Integer.MIN_VALUE;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int tmp = 0;
            level++;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                tmp += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);                
            }
            if(maxi < tmp){
                maxi = tmp;
                ans = level;
            }
        }
        return ans;
    }
}