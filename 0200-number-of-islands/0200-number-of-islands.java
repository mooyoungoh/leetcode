class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    traversal(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void traversal(char[][] grid, int i, int j){
        grid[i][j] = 'x';
        
        //top
        if(i > 0 && grid[i - 1][j] == '1') traversal(grid, i - 1, j);
        //down
        if(i < grid.length - 1&& grid[i + 1][j] == '1') traversal(grid, i + 1, j);
        //left
        if(j > 0 && grid[i][j-1] == '1') traversal(grid, i, j - 1);
        //right
        if(j < grid[0].length - 1 && grid[i][j+1] =='1') traversal(grid, i, j + 1);
    }
}