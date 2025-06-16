class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited = grid;

        Queue<int[]> q = new LinkedList<>();

        int freshOrange = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0) return 0;
        if(q.isEmpty()) return -1;

        int[][] dirs ={{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minutes = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[] dir : dirs){
                    int nx = dir[0] + cell[0];
                    int ny = dir[1] + cell[1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && visited[nx][ny] == 1){
                        visited[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                        freshOrange--;
                    }
                }
            }
            minutes++;
        }
        return freshOrange == 0 ? minutes : -1; 
    }
}