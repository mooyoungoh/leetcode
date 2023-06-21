class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] o = obstacleGrid;
        int[][] dp = new int[o.length][o[0].length];
        dp[0][0] = 1;
        for(int i = 0; i < o.length; i++){
            for(int j = 0; j < o[0].length; j++){
                if(o[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[o.length-1][o[0].length-1];
    }
}