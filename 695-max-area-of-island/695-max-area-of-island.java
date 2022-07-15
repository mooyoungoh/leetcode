class Solution {
    
    int max = 0;
    int maxnow = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    maxnow = 0;
                    helper(grid, i, j);
                }
            }
        }
        
        return max;
    }
    
    
    private void helper(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = -1;
        maxnow++;
        
        helper(grid, i-1,j);
        helper(grid, i+1,j);
        helper(grid, i,j-1);
        helper(grid, i,j+1);
        
        max = Math.max(max, maxnow);
    }
}

/*
[1,1,0,0,0],
[1,1,0,0,0],
[0,0,0,1,1],
[0,0,0,1,1]

*/