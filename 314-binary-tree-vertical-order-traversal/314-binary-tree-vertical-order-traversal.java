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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> weight = new HashMap<>();
        
        q.offer(root);
        weight.put(root, 0);
        
        int min = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int w = weight.get(node);
            if(!map.containsKey(w)){
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if(node.left != null){
                q.offer(node.left);
                weight.put(node.left, w-1);
            }
            if(node.right != null){
                q.offer(node.right);
                weight.put(node.right, w+1);
            }
            min = Math.min(min, w);
        }
        while(map.containsKey(min)){
            ans.add(map.get(min++));
        }
        return ans;
    }
}