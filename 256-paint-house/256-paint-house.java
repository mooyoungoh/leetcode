class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int j = 0; j < n; j++){
            dp[0][j] = costs[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = costs[i][j] + minFind(i-1, j, dp);
            }
        }
        return minFind(m-1, -1, dp);
    }
    
    private int minFind(int i, int j, int[][] matrix){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < matrix[0].length; k++){
            if(k == j) continue;
            min = Math.min(min, matrix[i][k]);
        }
        return min;
    }
}



/*
costs = [[17,2,17],[16,16,5],[14,3,19]]
dp    = [[17,2,17],[18,33,7],[21,10, ]]
    


*/