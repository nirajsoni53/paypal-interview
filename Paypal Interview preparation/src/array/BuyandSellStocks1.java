package array;


/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
* 121. Best Time to Buy and Sell Stock
* Easy
 * */
public class BuyandSellStocks1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] > prices[i]){
                    maxProfit = Math.max((prices[j] - prices[i]), maxProfit);
                }
            }
        }
        return maxProfit;
    }

    /*
     prices = [7,1,5,3,6,4]
     aux = [7,6,6,6,6,4] //Pre-computed array
     O(n), O(n)
    */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int[] aux = new int[prices.length];
        for(int i = prices.length - 1; i >= 0; i--){
            if(prices.length - 1 == i){
                aux[i] = prices[i];
            }
            else{
                aux[i] = Math.max(prices[i], aux[i + 1]);
            }
        }

        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(aux[i] - prices[i], maxProfit);
        }
        return maxProfit;
    }

    /*
      prices = [7,1,5,3,6,4]

      minValue = Integer.MAX_VALUE;
      profit = 0;

      Here we increment i and check minvalue and every we calculate diffrence between
      minValue and i.

      0  1  2  3  4  5
      7, 1, 5, 3, 6, 4
      i

    */
    public int maxProfit3(int[] prices) {
        if(prices.length == 0) return 0;
        int minValue = Integer.MAX_VALUE;
        int profit = 0;

        for(int currentValue: prices){
            minValue = Math.min(minValue, currentValue);
            profit = Math.max(currentValue - minValue, profit);
        }

        return profit;
    }

    public static void main(String[] args) {
        new BuyandSellStocks1().maxProfit2(new int[]{7,1,5,3,6,4});
    }
}
