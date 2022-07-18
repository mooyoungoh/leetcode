class Solution {
    private final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int dist = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        
        int[][] visited = new int[m][n];
        for(int[] i : visited)
            Arrays.fill(i, Integer.MAX_VALUE);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int []cur = q.poll();
                if(cur[0] == m-1 && cur[1] == n-1)return dist;
                for(int[] dir : DIRS){
                    int newX = dir[0] + cur[0];
                    int newY = dir[1] + cur[1];
                    
                    if(newX < 0 || newY < 0 || newX >= m || newY >=n)
                        continue;
                    
                    int newK = grid[newX][newY] + cur[2];
                    
                    if(newK > k) continue;
                    if(visited[newX][newY] <= newK) continue;
                    
                    visited[newX][newY] = newK;
                    q.offer(new int[]{newX, newY, newK});
                }
            }
            dist++;
        }
        return -1;
    }
}