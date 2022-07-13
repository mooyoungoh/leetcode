class Solution {
    private final int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] reach = new int[m][n];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i,j});
                    bfs(q,grid, dp, reach, m, n);
                    count++;
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && reach[i][j]==count){
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE? -1 : result;
    }
    
    private void bfs(Queue<int[]> q, int[][] grid, int[][] dp, int[][] reach, int m, int n){
        int level = 1;
        boolean[][] visited = new boolean[m][n];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : DIRS){
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if(dx < 0 || dx > m-1 || dy < 0 || dy > n-1 || visited[dx][dy] || grid[dx][dy] !=0 )
                        continue;
                    q.offer(new int[]{dx, dy});
                    visited[dx][dy] = true;
                    dp[dx][dy] += level;
                    reach[dx][dy]++;
                }
            }
            level++;
        }
    }
}