class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        d[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                d[i][j] += (i > 0) ? d[i-1][j] : 0;
                d[i][j] += (j > 0) ? d[i][j-1] : 0;
            }
        }
        return d[m-1][n-1];
    }
}