package dp.coinChangeMaxWays;

public class CoinChangeMemoization {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;
        if(len == 1){
            if(amount % coins[0] == 0) return amount / coins[0];
            else return -1;
        }

        int[][] cache = new int[coins.length][amount];
        for(int i = 0; i < cache.length; i++){
            for(int j = 0; j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
        return coinChange(coins, amount, 0, 0, cache);
    }

    public int coinChange(int[] coins, int amount, int sum, int i, int[][] cache) {
        if(sum == amount) return 1;
        if(i >= coins.length || sum > amount) return 0;

        if (cache[i][sum] != -1) return cache[i][sum];

        if(coins[i] < amount){
            return cache[i][sum] = coinChange(coins, amount, sum + coins[i], i, cache) +
                    coinChange(coins, amount, sum, i+1, cache);
        }else return cache[i][sum] = coinChange(coins, amount, sum, i + 1, cache);
    }

    public static void main(String[] args) {
        int result = new CoinChangeMemoization().coinChange(new int[]{1,2,5}, 11);
        System.out.println(result);

        result = new CoinChangeMemoization().coinChange(new int[]{1,2,3}, 5);
        System.out.println(result);
    }
}
