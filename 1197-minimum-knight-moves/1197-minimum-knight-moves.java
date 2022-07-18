class Solution {
    
    private final int[][] DIRS ={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    
    public int minKnightMoves(int x, int y) {
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0});
        
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int dist = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[]cur = q.poll();
                if(cur[0] == x && cur[1] == y) return dist;
                for(int[] dir : DIRS){
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    
                    if(!set.contains(nx +","+ny) && nx >= -1 && nx>=-1){
                        q.add(new int[]{nx, ny});
                        set.add(nx+","+ny);
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}