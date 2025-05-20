class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == 2){
                    q.offer(new int[] {i, j});
                }
                if(visited[i][j] == 1){
                    countFresh++;
                }
            }
        }

        if(countFresh == 0) return 0;
        if(q.isEmpty()) return -1;

        int minutes = -1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && visited[nx][ny] == 1){
                        visited[nx][ny] = 2;
                        countFresh--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            minutes++;
        }

        if(countFresh == 0) return minutes;
        return -1;

    }
}