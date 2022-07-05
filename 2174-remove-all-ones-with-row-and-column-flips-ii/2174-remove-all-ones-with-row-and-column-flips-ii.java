class Solution {
    public int removeOnes(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int minFlips = Integer.MAX_VALUE;
        int[] rowValues = new int[N], colValues = new int[M];
        for(int row = 0; row < M; row++) {
            for(int col = 0; col < N; col++) {
                if(grid[row][col] == 0) {
                    continue;
                }
                for(int r = 0; r < M; r++) {
                    colValues[r] = grid[r][col];
                    grid[r][col] = 0;
                }
                for(int c = 0; c < N; c++) {
                    rowValues[c] = grid[row][c];
                    grid[row][c] = 0;
                }
                minFlips = Math.min(minFlips, (1 + removeOnes(grid)));
                for(int c = 0; c < N; c++) {
                    grid[row][c] = rowValues[c];
                }
                for(int r = 0; r < M; r++) {
                    grid[r][col] = colValues[r];
                }
            }
        }
        return ((minFlips == Integer.MAX_VALUE) ? 0 : minFlips);
    }
}