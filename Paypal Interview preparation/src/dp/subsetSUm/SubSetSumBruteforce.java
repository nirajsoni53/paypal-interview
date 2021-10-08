package dp.subsetSUm;

public class SubSetSumBruteforce {
    public boolean subSetSum(int[] arr, int sum){
        if(arr.length == 0) return false;
        return subSetSum(arr, sum, 0, 0);
    }

    private boolean subSetSum(int[] arr, int sum, int result,
                              int i){
        if(result == sum) return true;
        else if(result > sum || i >= arr.length) return false;

        if(arr[i] < sum) {
            return subSetSum(arr, sum, result + arr[i], i + 1) ||
                    subSetSum (arr, sum, result, i + 1);
        }
        else return subSetSum(arr, sum, result, i+1);
    }
    public static void main(String[] args) {
        System.out.println("True Output");
        boolean result = new SubSetSumBruteforce().subSetSum(new int[]{1,4,7,8,10}, 13);
        System.out.println(result);
        result = new SubSetSumBruteforce().subSetSum(new int[]{1,4,7,8,10}, 14);
        System.out.println(result);
        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 11);
        System.out.println(result);
        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 20);
        System.out.println(result);
        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 22);
        System.out.println(result);
        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 9);
        System.out.println(result);


        /* False */
        System.out.println("False Output");
        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 6);
        System.out.println(result);

        result = new SubSetSumBruteforce().subSetSum(new int[]{2,3,7,8,10}, 4);
        System.out.println(result);
    }
}
