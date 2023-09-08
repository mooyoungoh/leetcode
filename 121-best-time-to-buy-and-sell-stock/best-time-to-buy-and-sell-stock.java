class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i++){
            int cur = prices[i];
            if(cur < buy){
                buy = cur;
                continue;
            }
            sell = Math.max(sell, cur - buy);
        }
        return sell;
    }
}