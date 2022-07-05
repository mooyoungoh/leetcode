class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int j = 0 ; j < n; j++){
            if(grid[0][j] == 1){
                
                for(int i = 0 ; i < m; i++){
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0;
                }
            }
        }
        /*
        for(int i = 1; i < m ; i++){
            for(int j = 0; j < n-1; j++){
                System.out.print(grid[i][j] + " " + grid[i][j+1]);
                if(grid[i][j] != grid[i][j+1]){
                    return false;
                }
            }
        }
        */
        
        for(int i = 1; i < m; i++){
            int sum = 0;
            for(int j=0; j < n; j++){
                sum += grid[i][j];
            }
            
            //System.out.println(sum);
            if(sum != 0 && sum != n){
                return false;
            }
        }
        
        return true;
    }
}

/*
101
101
010

*/