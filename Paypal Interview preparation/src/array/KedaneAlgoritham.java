package array;

public class KedaneAlgoritham {

    public static int findSubArraySum(int[] array){
        int maxSum = 0;
        int sum = 0;
        for(int i = 0; i< array.length; i++){
            sum += array[i];
            for(int j = i+1; j<array.length; j++){
                sum+= array[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
            sum = 0;
        }
        return maxSum;
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < size; i++)
        {
            sum = sum + a[i];
            if (maxSum < sum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findSubArraySum(new int[]{-2,-3,4,-1,-2,1,5,-3}));
        System.out.println(maxSubArraySum(new int[]{-1,-2,-3,-4,-5,-6}));
    }
}
