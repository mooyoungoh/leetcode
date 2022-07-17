class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int[][] d = new int[o.length][o[0].length];
        d[0][0] = 1;
            
        for(int i = 0; i < o.length; i++){
            for(int j = 0; j < o[0].length; j++){
                int cur = o[i][j];
                if(cur == 1){
                    d[i][j] = 0;
                }else{
                    if(i>0) d[i][j]+=d[i-1][j];
                    if(j>0) d[i][j]+=d[i][j-1];
                }
            }
        }
        
        return d[o.length-1][o[0].length-1];
    }
}