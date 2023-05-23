class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        for(int price : prices){
            buy = Math.min(buy, price);
            sell = Math.max(price - buy, sell);
        }
        return sell;
    }
}