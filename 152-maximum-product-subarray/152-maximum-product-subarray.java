class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int c = nums[i];
            dp[i][0] = Math.max(c, Math.max(c*dp[i-1][0], c*dp[i-1][1]));
            dp[i][1] = Math.min(c, Math.min(c*dp[i-1][0], c*dp[i-1][1]));
            
            if(max < dp[i][0])
                max = dp[i][0];
        }
        return max;
    }
}