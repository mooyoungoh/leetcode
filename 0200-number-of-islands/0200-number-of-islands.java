class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    backtrack(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void backtrack(char[][] grid, int i, int j){
        //up
        grid[i][j] = 'x';
        if(i - 1 >= 0 && grid[i - 1][j] == '1') backtrack(grid, i - 1, j);
        //down
        if(i + 1 < grid.length && grid[i + 1][j] == '1') backtrack(grid, i + 1, j);
        //left
        if(j - 1 >= 0 && grid[i][j - 1] == '1') backtrack(grid, i, j-1);
        //right
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1')backtrack(grid, i, j + 1);
    }
}