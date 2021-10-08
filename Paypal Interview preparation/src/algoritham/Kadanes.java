package algoritham;

public class Kadanes {
    static int findLargestSumOfSubArray(int[] arr){// 1 -2, -2, 4
        int maxSum = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            for(int j = i+1; j < arr.length; j++){
                sum += arr[j];
            }
            if(sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findLargestSumOfSubArray(new int[] {1, -2, -3, 4}));
    }
}
