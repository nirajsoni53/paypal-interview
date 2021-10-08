package dp.subsetSUm;

/*
* Time: O(N * S)
* Space : O(N * S), n is length of array and S is total no of sums
* */
public class SubSetSumMemoization {

    public boolean subSetSum(int[] arr, int sum){
        if(arr.length == 0) return false;
        boolean[][] cache = new boolean[arr.length + 1][sum + 1];
        return subSetSum(arr, sum, 0, 0, cache);
    }

    private boolean subSetSum(int[] arr, int sum, int result,
                              int i, boolean[][] cache){
        if(result == sum) return true;
        else if(result > sum || i >= arr.length) return false;

        if(cache[i][result]) return cache[i][result];

        if(arr[i] < sum) {
           return cache[i][result] = subSetSum(arr, sum, result + arr[i], i + 1, cache) ||
                subSetSum (arr, sum, result, i + 1, cache);
        }
        else return cache[i][result] = subSetSum(arr, sum, result, i+1, cache);
    }
    public static void main(String[] args) {
        System.out.println("True Output");
        boolean result = new SubSetSumMemoization().subSetSum(new int[]{1,4,7,8,10}, 13);
        System.out.println(result);
        result = new SubSetSumMemoization().subSetSum(new int[]{1,4,7,8,10}, 14);
        System.out.println(result);
        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 11);
        System.out.println(result);
        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 20);
        System.out.println(result);
        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 22);
        System.out.println(result);
        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 9);
        System.out.println(result);


        /* False */
        System.out.println("False Output");
        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 6);
        System.out.println(result);

        result = new SubSetSumMemoization().subSetSum(new int[]{2,3,7,8,10}, 4);
        System.out.println(result);
    }
}
