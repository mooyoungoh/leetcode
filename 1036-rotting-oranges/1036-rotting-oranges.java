class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] visited = grid;

        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                if(visited[i][j] == 1){
                    countFresh++;
                }
            }
        }

        if(countFresh == 0) return 0;
        if(q.isEmpty()) return -1;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean newRot = false; // Check if any new orange rotted this minute
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int nx = cell[0] + dir[0];
                    int ny = cell[1] + dir[1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        countFresh--;
                        q.offer(new int[]{nx, ny});
                        newRot = true;
                    }
                }
            }
            if (newRot) minutes++; // Only increment if new rot occurred
        }
        if(countFresh == 0) return minutes;
        return -1;
    }
}