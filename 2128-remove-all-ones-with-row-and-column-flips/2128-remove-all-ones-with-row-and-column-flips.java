class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                for(int i = 0; i < m; i++){
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }
        
        for(int i = 0 ; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += grid[i][j];
            }
            
            if(sum != 0 && sum != n){
                return false;
            }
        }
        
        
        return true;
    }
}