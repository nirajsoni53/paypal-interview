package dp.coinChangeMinCoins;

/*
 * Time: O(C * A) cis for coins, and A for amount
 * Space: O(C * A) + O(N) stack space
 * */
public class CoinChangeMinCoinDP {
    public int minNoOfCoins(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        int[][] cache = new int[coins.length + 1][amount + 1];

        /* First row Initialize with Integer.MAX_VALUE*/
        for(int j = 0; j < cache[0].length; j++)
            cache[0][j] = Integer.MAX_VALUE - 1;

        /* First column initialize with 0*/
        for(int i = 1; i < cache.length; i++)
            cache[i][0] = 0;

        /* Initialize second row*/
        for(int j = 1; j < cache[0].length; j++)
        {
            if(j % coins[0] == 0) cache[1][j] = j / coins[0];
            else cache[1][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 2; i < cache.length; i++){
            for(int j = 1; j < cache[0].length; j++){
                if(coins[i - 1] <= j)
                    cache[i][j] = Math.min(1 + cache[i][j - coins[i-1]], cache[i-1][j]);
                else cache[i][j] = cache[i-1][j];
            }
        }

        return cache[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : cache[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChangeMinCoinDP minCoins = new CoinChangeMinCoinDP();
        int result = minCoins.minNoOfCoins(new int[]{1,10,5}, 11);
        System.out.println(result);

        result = minCoins.minNoOfCoins(new int[]{1}, 1);
        System.out.println(result);

        result = minCoins.minNoOfCoins(new int[]{1, 2, 5}, 11);
        System.out.println(result);

        result = minCoins.minNoOfCoins(new int[]{1}, 0);
        System.out.println(result);

        result = minCoins.minNoOfCoins(new int[]{1}, 2);
        System.out.println(result);

        result = minCoins.minNoOfCoins(new int[]{2}, 3);
        System.out.println(result);
    }
}
