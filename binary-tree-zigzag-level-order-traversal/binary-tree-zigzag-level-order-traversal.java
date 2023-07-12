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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean zig = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(zig){
                    tmp.add(node.val);
                }else{
                    tmp.add(0, node.val);
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            zig = !zig;
            ans.add(tmp);
        }
        return ans;
    }
}