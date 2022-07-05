class Solution {
    public int minCost(int[][] costs) {
        
  if(costs.length == 0 || costs[0].length == 0)
        return 0;
    int m = costs.length, n = costs[0].length;
    
    //initialize dp matrix
    int[][] dp = new int[m][n];
    for(int j = 0; j < n; j++) 
        dp[0][j] = costs[0][j];
        
    //fill the dp matrix
    for(int i = 1; i < m; i++) {
        for(int j = 0; j < n; j++)
            dp[i][j] = costs[i][j] + findMinInOneRow(i - 1, j, dp);
    }
    
    return findMinInOneRow(m - 1, -1, dp);
}

private int findMinInOneRow(int i, int j, int[][] matrix) {
    int min = Integer.MAX_VALUE;
    for(int k = 0; k < matrix[0].length; k++) {
        if(k == j)
            continue;
        min = Math.min(min, matrix[i][k]);
    }
    return min;
}
}

/*
res blue green


*/

