class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for(int price : prices){
            if(buy > price){
                buy = price;
            }else{
                sell += (price - buy);
                buy = price;
            }
        }
        return sell;
    }
}