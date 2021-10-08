package algoritham.sliding_window;

public class MaxSIzeunarrayForGivenSum {

    static int findMaxSizeSubArrayForGivenSum(int[] a, int sum){
        int len = a.length;
        if(len == 0) return 0;

        int i= 0;
        int j = 0;

        int maxSum = 0;
        int result = a[i];
        while(i <= j && j < len){
            if(result < sum){
                j++;
                if(j< len) result += a[j];
            }else if(result > sum){
                result -= a[i];
                i++;
            }else{
                maxSum = Math.max(j - i, maxSum);
                j++;
                if(j< len) result += a[j];
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        findMaxSizeSubArrayForGivenSum(new int[]{1,3,2,0,0,0,2,1}, 5);
    }
}
