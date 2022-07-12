class Solution {
    
    final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dp = new int[n][m];
        int[][]reach = new int[n][m];
        int countBuilding = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    bfs(q, grid, dp, reach, n, m);
                    countBuilding++;
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && reach[i][j] == countBuilding){
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    
    public void bfs(Queue<int[]> q, int[][] grid, int[][] dp, int[][] reach, int n, int m){
        int level = 1;
        boolean[][] visited = new boolean[n][m];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : DIRECTIONS){
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if(dx < 0 || dx > n-1 || dy <0 || dy> m-1 || grid[dx][dy] != 0 || visited[dx][dy])
                        continue;
                    q.offer(new int[]{dx,dy});
                    visited[dx][dy] = true;
                    dp[dx][dy] += level;
                    reach[dx][dy]++;
                }
            }
            level++;
        }
    }
}