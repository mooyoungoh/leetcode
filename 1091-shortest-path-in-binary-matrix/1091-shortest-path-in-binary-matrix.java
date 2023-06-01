class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        
        if(grid == null || grid.length == 0) return -1;
        
        if(grid[0][0] != 0) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0});
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1) return curr[2]+1;
            
            
            for(int i=0; i < dirs.length; i++){
                int x = curr[0] + dirs[i][0];
                int y = curr[1] + dirs[i][1];
                
                if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0) continue;
                
                grid[x][y] = -1;
                queue.add(new int[]{x,y, curr[2]+1});
            }
        }
        
        return -1;
    }
}