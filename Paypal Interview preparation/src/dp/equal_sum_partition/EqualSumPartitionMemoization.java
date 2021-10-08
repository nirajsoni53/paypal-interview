package dp.equal_sum_partition;

public class EqualSumPartitionMemoization {

    public boolean equalSumPartition(int[] arr, int targetSum) {
        if(arr.length == 0) return false;
        int sum = 0;
        for(int value : arr) sum += value;
        if(sum % 2 == 1 || sum / 2 != targetSum) return false;
        boolean[][] cache = new boolean[arr.length][targetSum];
        return findSubSetSum(arr, targetSum, 0, 0, cache);
    }

    private boolean findSubSetSum(int[] arr, int targetSum, int sum, int i, boolean[][] cache){
        if(sum == targetSum) return true;
        else if(i >= arr.length || sum > targetSum) return false;

        if(cache[i][sum]) return cache[i][sum];

        if(arr[i] < targetSum)
            return cache[i][sum] = findSubSetSum(arr, targetSum, sum + arr[i], i + 1,cache) ||
                    findSubSetSum(arr, targetSum, sum, i + 1,cache);
        else return cache[i][sum] = findSubSetSum(arr, targetSum, sum, i + 1, cache);
    }

    public static void main(String[] args) {
        EqualSumPartitionMemoization equalSumPartition = new EqualSumPartitionMemoization();
        boolean result = equalSumPartition.equalSumPartition(new int[]{1, 5, 11, 5}, 11);
        System.out.println(result);
        result = equalSumPartition.equalSumPartition(new int[]{3, 3, 3, 3}, 6);
        System.out.println(result);
        result = equalSumPartition.equalSumPartition(new int[]{4, 4, 4, 5, 7}, 12);
        System.out.println(result);

        result = equalSumPartition.equalSumPartition(new int[]{3, 4, 4, 1}, 6);
        System.out.println(result);
    }
}
