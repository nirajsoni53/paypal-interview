package array;

/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
* 122. Best Time to Buy and Sell Stock II
* Medium
 * */
public class BuyAndSellStock2 {

    /*
        Prices = [7,1,5,3,6,4]
        [7, 1, 5, 3, 6, 4]
        1 > 7 = don't do anything
        5 > 1 = 5 - 1 = profit
        3 > 5 = don't do anything
        6 > 3 = 6 - 3 = profit
        4 > 6 = don't do anything

        sum of all profit will be my answer
    */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
