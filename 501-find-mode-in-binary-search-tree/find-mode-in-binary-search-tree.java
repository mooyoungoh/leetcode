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
    
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        tre(root);
        int maxFreq = 0;
        for(int key : map.keySet()){
            maxFreq = Math.max(maxFreq, map.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq){
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }

    public void tre(TreeNode root){
        if(root == null) return;

        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if(root.left != null) tre(root.left);
        if(root.right != null) tre(root.right);
    } 
}