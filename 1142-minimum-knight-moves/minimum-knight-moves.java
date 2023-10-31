class Solution {
    
    private final int[][] DIRS ={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    
    public int minKnightMoves(int x, int y) {
    
        x = Math.abs(x);
        y = Math.abs(y);
        
        Set<String> set = new HashSet<>();
        set.add("0,0");
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int dist = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] cur = q.poll();
                if(cur[0] == x && cur[1] == y) return dist;
                for(int[] dir : DIRS){
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    if(!set.contains(newX+","+newY) && newX >=-1 && newY >=-1){
                        set.add(newX+","+newY);
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}