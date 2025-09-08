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

        int min = -1;

        int[][] dirs ={{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[] dir : dirs){
                    int x = dir[0] + cell[0];
                    int y = dir[1] + cell[1];

                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && 
                    visited[x][y] == 1){
                        q.offer(new int[]{x,y});
                        visited[x][y] = 2;
                        freshOrange--;
                    }

                }
            }
            min++;
        }
        return freshOrange == 0 ? min : -1;
    }
}