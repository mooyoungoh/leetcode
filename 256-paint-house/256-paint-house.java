class Solution {
    /*
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int j = 0; j < n; j++){
            dp[0][j] = costs[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0 ; j < n; j++){
                dp[i][j] = costs[i][j] + findMin(i-1, j, dp);
            }
        }
        
        return findMin(m-1, -1, dp);
    }
    
    private int findMin(int i, int j, int[][] matrix){
        int min = Integer.MAX_VALUE;
        for(int k = 0 ; k < matrix[0].length; k++){
            if(k == j){
                continue;
            }
            min = Math.min(min, matrix[i][k]);
        }
        return min;
    }
}

*/


    private int[][] costs;
    private Map<String, Integer> memo;

    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        this.costs = costs;
        this.memo = new HashMap<>();
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color) {
        if (memo.containsKey(getKey(n, color))) {
            return memo.get(getKey(n, color));   
        }
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }        
        memo.put(getKey(n, color), totalCost);

        return totalCost;
    }

    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
}
    