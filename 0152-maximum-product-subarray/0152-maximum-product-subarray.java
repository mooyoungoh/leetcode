class Solution {
    public int maxProduct(int[] nums) {
        int[][] d = new int[nums.length][2];
        d[0][0] = nums[0];
        d[0][1] = nums[0];
        
        int ans = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int c = nums[i];
            d[i][0] = Math.max(c, Math.max(c * d[i-1][0], c * d[i-1][1]));
            d[i][1] = Math.min(c, Math.min(c * d[i-1][0], c * d[i-1][1]));
            
            if(d[i][0] > ans){
                ans = d[i][0];
            }
        }
        
        return ans;
    }
}