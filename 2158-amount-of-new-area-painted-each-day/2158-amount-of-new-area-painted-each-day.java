class Solution {
    public int[] amountPainted(int[][] paint) {
        int[] ans = new int[paint.length];
        int[] canvas = new int[500001];
        int idx = 0;
        for(int[]p : paint){
            int count = 0;
            int index = p[0];
            while(index < p[1]){
                if(canvas[index] == 0){
                    canvas[index] = p[1];
                    count++;
                    index++;
                }else{
                    index = canvas[index];
                }
            }
            ans[idx++] = count;
        }
        
        return ans;
    }
}