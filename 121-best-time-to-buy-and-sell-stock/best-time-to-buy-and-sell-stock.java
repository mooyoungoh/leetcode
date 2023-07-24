class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for(int price : prices){
            buy = Math.min(price, buy);
            sell = Math.max(price - buy, sell);
        }
        return sell;
    }
}