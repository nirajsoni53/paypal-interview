package dp.coinChangeMinCoins;

/*
* Time: O(C * A) cis for coins, and A for amount
* Space: O(C * A)
* */
public class CoinChangeMinCoinsMemoization {

    public int minNoOfCoins(int[] arr, int targetSum) {
        if (arr.length == 0 || targetSum == 0) return 0;
        int[][] cache = new int[arr.length][targetSum];
        for(int i = 0; i < cache.length; i++){
            for(int j = 0; j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
        int minWays = minNoOfCoins(arr, targetSum, 0, 0, cache);
        return minWays == Integer.MAX_VALUE - 1 ? -1 : minWays;
    }

    private int minNoOfCoins(int[] arr, int targetSum, int sum, int i, int[][] cache) {
        if (sum == targetSum) return 0;
        if (sum > targetSum || i >= arr.length) return Integer.MAX_VALUE - 1;

        if(cache[i][sum] != -1) return cache[i][sum];

        if (arr[i] <= targetSum) {
            return cache[i][sum] = Math.min(
                    1 + minNoOfCoins(arr, targetSum, sum + arr[i], i, cache),
                    minNoOfCoins(arr, targetSum, sum, i + 1, cache)
            );
        }
        else return cache[i][sum] = minNoOfCoins(arr, targetSum, sum, i + 1, cache);
    }

    public static void main(String[] args) {
        CoinChangeMinCoinsMemoization minCoins = new CoinChangeMinCoinsMemoization();
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
