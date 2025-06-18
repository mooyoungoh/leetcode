class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0) continue;
                int left = (j > 0) ? dp[i][j-1] : Integer.MAX_VALUE;
                int up = (i > 0) ? dp[i-1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(left, up) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}