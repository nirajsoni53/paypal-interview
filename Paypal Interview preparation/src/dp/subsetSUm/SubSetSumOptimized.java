package dp.subsetSUm;


/*
* Time: O(N * S)
* Space: O(N * S)
*
* Here, N is no of element and S means required sum.
*
* Note: if we constraints for limited data arr[1000][1000]
* So we can preProcess it and when we require sum we can get by
* [array.length][sum]
* */
public class SubSetSumOptimized {
    public boolean subSetSum(int[] arr, int sum){
        if(arr.length == 0) return false;
        // here length of arr denote i and sum denote j
        boolean[][] cache = new boolean[arr.length + 1][sum + 1];
        // Here if sum(j) 0 means no subset require hence all column will true;
        for(int i = 0; i <= arr.length; i++) cache[i][0] = true;
        // Here if arr is empty then no subset possible hence all row will false;
        for(int j = 1; j <= sum; j++) cache[0][j] = false;
        for (int i = 1; i <= arr.length; i++){
            for (int j = 1; j <= sum; j++){
                /*
                * If current sum (j) is >= current number at index then sum is possible
                * so we will calculate sum for it.
                *
                * Here is way how we calculate sum
                *
                * if sum = 5
                * and current number arr[i] is = 3 then sum - arr[i] = 2
                * means 2 is require to complete our sum so, if we not
                * consider(exclude) 3 right now means [i-1] and check index at 2
                * for j = sum(j)(5) - current number arr[i-1](3) = 2.
                * so a[i -1][j - arr[i-1] || we can check if we not include 3
                * then what should be my answer by a[i-1][j] which for sum 5 if
                * we exclude 3 then what should be my answer.
                * */
                if(j >= arr[i - 1]) cache[i][j] = cache[i-1][j - arr[i - 1]] || cache[i - 1][j];
                else cache[i][j] = cache[i - 1][j];
            }
        }
        // At last we return last row and column.
        return cache[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println("True Output");
        boolean result = new SubSetSumOptimized().subSetSum(new int[]{1,4,7,8,10}, 13);
        System.out.println(result);
        result = new SubSetSumOptimized().subSetSum(new int[]{1,4,7,8,10}, 14);
        System.out.println(result);
        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 11);
        System.out.println(result);
        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 20);
        System.out.println(result);
        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 22);
        System.out.println(result);
        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 9);
        System.out.println(result);

        /* False */
        System.out.println("False Output");
        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 6);
        System.out.println(result);

        result = new SubSetSumOptimized().subSetSum(new int[]{2,3,7,8,10}, 4);
        System.out.println(result);
    }
}
