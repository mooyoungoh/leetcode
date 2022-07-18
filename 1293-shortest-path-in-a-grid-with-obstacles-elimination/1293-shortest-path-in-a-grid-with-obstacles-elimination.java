class Solution {
    
    private final int[][] DIRS = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public int shortestPath(int[][] grid, int k) {
    
        int m = grid.length;
        int n = grid[0].length;
        
        int dist = 0;
        
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        
        int[][] visited = new int[m][n];
        for(int[] i : visited)
            Arrays.fill(i, Integer.MAX_VALUE);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] cur = q.poll();
                if(cur[0] == m-1 && cur[1] == n-1) return dist;
                for(int[] dir : DIRS){
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    
                    if(newX < 0 || newX >= m || newY <0 || newY >= n)
                        continue;
                    
                    int newK = cur[2] + grid[newX][newY];
                    
                    if(visited[newX][newY] <= newK)continue;
                    if(newK > k) continue;
                    
                    visited[newX][newY] = newK;
                    q.offer(new int[]{newX,newY,newK});
                }
            }
            dist++;
        }
        return -1;
    }
}