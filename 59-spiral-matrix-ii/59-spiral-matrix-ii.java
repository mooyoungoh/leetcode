class Solution {
    public int[][] generateMatrix(int n) {
        int[][]res = new int[n][n];
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int count = 0;
        while(count < n*n){
            for (int i = left; i <= right && count < n*n; i++) res[top][i] = ++count;
            for (int i = top + 1; i < bottom && count < n*n; i++) res[i][right] = ++count;
            if(count < n*n){
                for (int i = right; i >= left && count < n*n; i--) res[bottom][i] = ++count;
                for (int i = bottom - 1; i > top && count < n*n; i--) res[i][left] = ++count;
            }
            left++;right--;top++;bottom--;
        }
        return res;
    }
}