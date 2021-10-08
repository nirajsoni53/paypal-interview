package dp.coinChangeMinCoins;

/*
* Time : O(2^n)
* Space : O(n) if consider stack space
* */
public class coinChangeMinCoins {
    public int minNoOfCoins(int[] arr, int targetSum) {
        if (arr.length == 0 || targetSum == 0) return 0;
        return minNoOfCoins(arr, targetSum, 0, 0);
    }

    private int minNoOfCoins(int[] arr, int targetSum, int sum, int i) {
        if (sum == targetSum) return 0;
        if (sum > targetSum || i >= arr.length) return Integer.MAX_VALUE - 1;

        if (arr[i] <= targetSum) {
            return Math.min(
                    1 + minNoOfCoins(arr, targetSum, sum + arr[i], i),
                    minNoOfCoins(arr, targetSum, sum, i + 1)
            );
        }
        else return minNoOfCoins(arr, targetSum, sum, i + 1);
    }

    public static void main(String[] args) {
        coinChangeMinCoins minCoins = new coinChangeMinCoins();
        /*int result = minCoins.minNoOfCoins(new int[]{1,10,5}, 11);
        System.out.println(result);*/

        int result = minCoins.minNoOfCoins(new int[]{1}, 1);
        System.out.println(result);
    }
}
