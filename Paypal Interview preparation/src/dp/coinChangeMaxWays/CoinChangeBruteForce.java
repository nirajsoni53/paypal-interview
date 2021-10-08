package dp.coinChangeMaxWays;

public class CoinChangeBruteForce {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;
        if(len == 1){
            if(amount % coins[0] == 0) return amount / coins[0];
            else return -1;
        }

        return coinChange(coins, amount, 0, 0);
    }

    public int coinChange(int[] coins, int amount, int sum, int i) {
        if(sum == amount) return 1;
        if(i >= coins.length || sum > amount) return 0;

        if(coins[i] < amount){
            return coinChange(coins, amount, sum + coins[i], i) +
                    coinChange(coins, amount, sum, i+1);
        }else return coinChange(coins, amount, sum, i + 1);
    }

    public static void main(String[] args) {
        int result = new CoinChangeBruteForce().coinChange(new int[]{1,2,5}, 11);
        System.out.println(result);

        result = new CoinChangeBruteForce().coinChange(new int[]{1,2,3}, 5);
        System.out.println(result);
    }
}
