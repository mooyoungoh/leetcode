class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[] flip = new boolean[n];
        
        for(int j = 0 ; j < n; j++){
            if(grid[0][j] == 1 && !flip[j]){
                flip[j] = true;
                for(int i = 0 ; i < m; i++){
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }
        
        for(int i = 1; i < m ; i++){
            for(int j = 0; j < n-1; j++){
                if(grid[i][j] != grid[i][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}