class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                boolean match = true;
                
                for(int i = 0; i < n; i++){
                    if(grid[r][i] != grid[i][c]){
                        match = false;
                        break;
                    }
                }
                count += match ? 1 : 0;
            }
        }
        
        return count;
    }
}