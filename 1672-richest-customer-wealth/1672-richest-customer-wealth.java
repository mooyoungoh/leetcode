class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for(int i = 0 ; i < accounts.length;i++){
            int tmp = 0;
            for(int j = 0 ; j < accounts[0].length; j++){
                tmp+=accounts[i][j];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}