class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for(int i = 0 ; i < n; i++){
            ans += mat[i][i];
            ans += mat[n-1-i][i];
        }
        return n%2==0 ? ans : ans - mat[n/2][n/2];
    }
}